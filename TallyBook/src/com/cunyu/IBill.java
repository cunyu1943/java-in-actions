package com.cunyu;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 村雨
 * @version : 1.0
 * @project : Java 实战
 * @package : com.cunyu
 * @className : IBill
 * @createTime : 2021/8/1 7:41
 * @email : 747731461@qq.com
 * @公众号 : 村雨遥
 * @website : https://cunyu1943.github.io
 * @description :
 */
public interface IBill {

    public void add();

    public void del();

    public void queryAll(List<Bill> billList);

    public void queryByTime(List<Bill> billList, String startTime, String endTime);

    public void queryByType(List<Bill> billList, String type);

    public void modify(int id);
}
