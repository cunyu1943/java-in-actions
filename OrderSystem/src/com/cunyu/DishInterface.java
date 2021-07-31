package com.cunyu;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 村雨
 * @version : 1.0
 * @project : Java 实战
 * @package : com.cunyu
 * @className : DishInterface
 * @createTime : 2021/7/31 20:26
 * @email : 747731461@qq.com
 * @公众号 : 村雨遥
 * @website : https://cunyu1943.github.io
 * @description :
 */
public interface DishInterface {
    /**
     * 初始化菜单
     *
     * @return 返回餐厅当前所提供的菜品列表
     */
    public List<Dish> initMenu();

    /**
     * 显示菜单
     *
     * @param dishList 菜品列表
     */
    public void showMenu(List<Dish> dishList);


    /**
     * 显示已经点过的菜品
     *
     * @param orderedList 当前已点菜品
     */
    public void showOrderedMenu(List<Dish> orderedList);

    /**
     * 移除菜品
     *
     * @param id          菜品对应序号
     * @param dishList    菜品列表
     * @param orderedList 已点菜品列表
     */
    public void deleteDish(int id, List<Dish> dishList, List<Dish> orderedList);

    /**
     * 结账
     *
     * @param orderedList
     */
    public void checkout(List<Dish> orderedList);
}
