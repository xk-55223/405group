package com.cskaoyan.mall.mallStart.shiro;

<<<<<<< HEAD
import com.cskaoyan.mall.mallStart.mapper.adminMapper.AdminFirstPageMapper;
=======
import com.cskaoyan.mall.mallStart.bean.Admin;
import com.cskaoyan.mall.mallStart.mapper.AdminFirstPageMapper;
import com.cskaoyan.mall.mallStart.mapper.AdminSystemMapper;
>>>>>>> 67beb030f74fdadbeca5f3ef180d4d7e11e57555
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
    AdminSystemMapper adminSystemMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 取得关键信息，这里是认证传过来的用户名
        String primaryPrincipal = (String) principalCollection.getPrimaryPrincipal();
        // 创建一个authorizationInfo，用以返回
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
<<<<<<< HEAD
        //根据用户名在数据库中查找该用户相应的权限
        List<String> permissions =  mapper.selectPermissionByUserName(primaryPrincipal);
        // 将该用户的权限授权给该用户
=======
        Admin admin = adminSystemMapper.selectAdminByUsername(primaryPrincipal);
        List<String> permissions = adminSystemMapper.selectPermsByRolesId(admin.getRoleIds());
>>>>>>> 67beb030f74fdadbeca5f3ef180d4d7e11e57555
        simpleAuthorizationInfo.addStringPermissions(permissions);
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //从token中获取关键信息，这里得到的关键信息是usernameAndPasswordToken中用户名
        String primaryPrincipal = (String) authenticationToken.getPrincipal();
<<<<<<< HEAD
        // 根据用户名从数据库中获取该用户的密码
        String password = mapper.selectPasswordByUserName(primaryPrincipal);
        // 将正确的用户名和密码封装给认证信息并返回
=======
        String password = adminSystemMapper.selectPasswordByUserName(primaryPrincipal);
>>>>>>> 67beb030f74fdadbeca5f3ef180d4d7e11e57555
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(primaryPrincipal, password, this.getName());
        return simpleAuthenticationInfo;
    }
}
