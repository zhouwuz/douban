package com.example.test.controller;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.test.common.Result;
import com.example.test.dao.UserDTO;
import com.example.test.service.IUserService;
import com.example.test.common.Constants;
import com.example.test.entity.User;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 周wz
 * @since 2022-06-07
 */
@RestController
@RequestMapping("/user")
public class UserController {

        @Resource
        private IUserService userService;

        //查找所有
        @GetMapping("/findAll")
        public List<User> findAll() {
                return userService.list();
        }
        //登录
        @PostMapping("/login")
        public Result login(@RequestBody UserDTO userDTO) {
                String account = userDTO.getAccount();
                String password = userDTO.getPassword();
                if (StrUtil.isBlank(account) || StrUtil.isBlank(password)) {
                        return Result.error(Constants.CODE_400,"参数错误");
                }

                UserDTO dto = userService.login(userDTO);
                return Result.success(dto);
        }

        //注册
        @PostMapping("/register")
        public Result register(@RequestBody UserDTO userDTO) {
                String username = userDTO.getUsername();
                String account = userDTO.getAccount();
                String password = userDTO.getPassword();
                String email = userDTO.getEmail();
                String phone = userDTO.getPhone();

                if (StrUtil.isBlank(username) || StrUtil.isBlank(password) ||StrUtil.isBlank(account)
                        || StrUtil.isBlank(email) || StrUtil.isBlank(phone)
                        ) {
                        return Result.error(Constants.CODE_400,"参数错误");
                }

                return Result.success(userService.register(userDTO));
        }
        //搜索并显示一页
        @GetMapping("/page")
        public Page<User> findPage(@RequestParam Integer pageNum,
                                   @RequestParam Integer pageSize,
                                   @RequestParam(defaultValue = "") String username) {

                QueryWrapper<User> queryWrapper = new QueryWrapper<>();
                queryWrapper.orderByDesc("id");
                if (!"".equals(username)) {
                        queryWrapper.like("username", username);
                }

                return userService.page(new Page<>(pageNum,pageSize),queryWrapper);
        }
        //删除
        @DeleteMapping("/{id}")
        public Boolean delete(@PathVariable Integer id) {
                return userService.removeById(id);
        }


}

