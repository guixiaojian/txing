package com.tx.realm;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import com.tx.model.pojo.User;
import com.tx.service.LoginService;
import com.tx.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;

public class UserRealm extends AuthorizingRealm {

	private static final Logger LOG = LoggerFactory.getLogger(UserRealm.class);

	@Autowired
	private UserService userService;

	@Override
	public String getName() {
		return "userRealm";
	}

	/**
	 * 授权
	 */
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

		LOG.info("开始授权");

		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

		String username = (String) principals.getPrimaryPrincipal();

		/*Set<String> role = new HashSet<String>();
		List<Role> roles = userService.findRoles(username);*/

		LOG.info("结束授权");
		return authorizationInfo;
	}

	/**
	 * 认证
	 */
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

		LOG.info("开始认证");

		// 获取用户名
 		String userName = (String) token.getPrincipal();
		String password = new String((char[]) token.getCredentials());
		// 根据用户名获取用户
		User user = userService.queryUserByUserName(userName);

		if(user == null){
			LOG.error("用户不存在！");
			throw new UnknownAccountException("用户不存在");
		}

		if (Boolean.TRUE.equals(user.getLocked())) {
			throw new LockedAccountException("用户已被禁用"); //账号锁定
		}

		// 获取到的用户交给AuthenticationRealm使用CredentialsMatcher进行密码匹配
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
				user,
				password,
				ByteSource.Util.bytes(user.getCredentialsSalt()),
				getName());

		LOG.info("认证结束");
		return authenticationInfo;
	}

}
