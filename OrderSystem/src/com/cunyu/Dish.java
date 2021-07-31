package com.cunyu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 村雨
 * @version : 1.0
 * @project : Java 实战
 * @package : com.cunyu
 * @className : Dish
 * @createTime : 2021/7/31 17:27
 * @email : 747731461@qq.com
 * @公众号 : 村雨遥
 * @website : https://cunyu1943.github.io
 * @description : 菜品类
 */
public class Dish implements DishInterface {
    /**
     * 编号
     */
    private int id;
    /**
     * 菜名
     */
    private String name;
    /**
     * 价格
     */
    private double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Dish() {
    }

    public Dish(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    /**
     * 初始化菜单
     *
     * @return 初始化后的菜单
     */
    @Override
    public List<Dish> initMenu() {
        List<Dish> dishList = new ArrayList<>();
        dishList.add(new Dish(1, "黄金手抓骨", 38));
        dishList.add(new Dish(2, "乡村爆火肉", 58));
        dishList.add(new Dish(3, "养生甲鱼汤", 68));
        dishList.add(new Dish(4, "三鲜汤", 28));
        dishList.add(new Dish(5, "紫菜蛋花汤", 18));
        dishList.add(new Dish(6, "铁板黄金蛋", 38));
        dishList.add(new Dish(7, "泡椒炒牛肉", 48));
        dishList.add(new Dish(8, "麻婆豆腐", 18));
        dishList.add(new Dish(9, "干煸豆角", 28));
        dishList.add(new Dish(10, "干锅娃娃菜", 29));
        dishList.add(new Dish(11, "干锅土豆丝", 28));
        dishList.add(new Dish(12, "清炒时蔬", 25));
        dishList.add(new Dish(13, "凉拌黄瓜", 10));
        dishList.add(new Dish(14, "胡椒皮蛋", 15));
        dishList.add(new Dish(15, "红烧茄子", 20));
        return dishList;
    }

    /**
     * 展示菜单
     *
     * @param dishList 菜品列表
     */
    @Override
    public void showMenu(List<Dish> dishList) {
        System.out.println("------------本店菜单------------");
        System.out.println("序号\t\t菜名\t\t\t\t单价");
        for (int i = 0; i < dishList.size(); i++) {
            System.out.format("%d\t\t%s\t\t\t%.2f\n", dishList.get(i).getId(), dishList.get(i).getName(), dishList.get(i).getPrice());
        }
        System.out.println("---------------------------");
    }


    /**
     * 删除对应菜品
     *
     * @param id          菜品对应序号
     * @param dishList    菜品列表
     * @param orderedList 已点菜品列表
     */
    @Override
    public void deleteDish(int id, List<Dish> dishList, List<Dish> orderedList) {
        orderedList.remove(dishList.get(id - 1));
    }


    /**
     * 查看已点的菜
     */
    @Override
    public void showOrderedMenu(List<Dish> orderedList) {
        if (orderedList.isEmpty()) {
            System.out.println("当前您还未点餐，请重新输入选择");
        } else {
            System.out.println("当前您点的菜品如下");
            for (int i = 0; i < orderedList.size(); i++) {
                System.out.println(orderedList.get(i).getName());
            }
        }

    }

    /**
     * 结账
     */
    @Override
    public void checkout(List<Dish> orderedList) {
        double money = 0.0d;
        if (orderedList.isEmpty()) {
            System.out.println("当前您还未点餐，请重新输入选择");
        } else {
            System.out.println("请稍等，正在结算中……");
            for (int i = 0; i < orderedList.size(); i++) {
                money += orderedList.get(i).getPrice();
            }
            System.out.format("你此次总共消费：￥ %.2f\n", money);
        }
    }
}
