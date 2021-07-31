package com.cunyu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 村雨
 * @version : 1.0
 * @project : Java 实战
 * @package : com.cunyu
 * @className : DishApp
 * @createTime : 2021/7/31 17:30
 * @email : 747731461@qq.com
 * @公众号 : 村雨遥
 * @website : https://cunyu1943.github.io
 * @description : 系统主界面
 */
public class DishApp {

    public static void main(String[] args) {
        Dish dish = new Dish();
        // 初始化菜单
        List<Dish> dishList = dish.initMenu();

        Scanner scanner = new Scanner(System.in);

        List<Dish> orderedList = new ArrayList<>();
        while (true) {
            System.out.println("----------欢迎使用点餐系统--------");
            System.out.println("----------【1】点菜--------------");
            System.out.println("----------【2】参看已点菜品-------");
            System.out.println("----------【3】删除菜品-----------");
            System.out.println("----------【4】结账--------------");
            System.out.println("----------【0】返回上一级/退出-----");

            System.out.println("输入你的选择");
            String choice = scanner.next();
            switch (choice) {
                case "1":
                    while (true) {
                        dish.showMenu(dishList);
                        System.out.println("请输入菜品序号进行点菜，输入 0 则返回上一级菜单");
                        int id = scanner.nextInt();
                        if (id == 0) {
                            break;
                        }

                        System.out.println("输入菜品序号:" + id);

                        System.out.println("你点的菜是：" + dishList.get(id - 1).getName());
                        // 把已点的菜加入已点菜单
                        orderedList.add(dishList.get(id - 1));
                    }
                    break;
                case "2":
                    dish.showOrderedMenu(orderedList);
                    break;
                case "3":
                    if (orderedList.isEmpty()) {
                        System.out.println("当前还未点菜，请重新输入你的选择");
                    } else {
                        System.out.println("输入要删除菜品的序号");
                        int id = scanner.nextInt();
                        dish.deleteDish(id, dishList, orderedList);
                    }
                    break;
                case "4":
                    dish.checkout(orderedList);
                    break;

                case "0":
                    System.exit(0);
                default:
                    break;
            }
        }
    }
}
