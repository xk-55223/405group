package com.cskaoyan.mall.mallStart.shiro;

import com.cskaoyan.mall.mallStart.mapper.AdminFirstPageMapper;
import com.cskaoyan.mall.mallStart.mapper.AdminUserMapper;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class CustomRealm extends AuthorizingRealm {
    @Autowired
    AdminFirstPageMapper mapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String primaryPrincipal = (String) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        List<String> permissions =  mapper.selectPermissionByUserName(primaryPrincipal);
        simpleAuthorizationInfo.addStringPermissions(permissions);
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String primaryPrincipal = (String) authenticationToken.getPrincipal();
        String password = mapper.selectPasswordByUserName(primaryPrincipal);
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(primaryPrincipal, password, this.getName());
        return simpleAuthenticationInfo;
    }
}
