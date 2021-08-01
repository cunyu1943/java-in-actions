package com.cunyu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 村雨
 * @version : 1.0
 * @project : Java 实战
 * @package : com.cunyu
 * @className : Bill
 * @createTime : 2021/8/1 8:10
 * @email : 747731461@qq.com
 * @公众号 : 村雨遥
 * @website : https://cunyu1943.github.io
 * @description :
 */


public class Bill implements IBill {
    private int id;
    /**
     * 类别
     */
    private String category;
    /**
     * 账户
     */
    private String account;
    /**
     * 类型
     */
    private String type;
    /**
     * 金额
     */
    private double amount;
    /**
     * 时间
     */
    private String time;
    /**
     * 备注
     */
    private String desc;

    public Bill(int id, String category, String account, String type, double amount, String time, String desc) {
        this.id = id;
        this.category = category;
        this.account = account;
        this.type = type;
        this.amount = amount;
        this.time = time;
        this.desc = desc;
    }

    public Bill() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


    @Override
    public void queryAll(List<Bill> billList) {
        for (Bill bill : billList) {
            System.out.println(bill.getId() + "\t\t" + bill.getCategory() + "\t\t" + bill.getAccount() + "\t\t" + bill.getType() + "\t\t" + bill.getAmount() + "\t\t" + bill.getTime() + "\t\t" + bill.getDesc());
        }
    }

    @Override
    public void add() {

    }

    @Override
    public void del() {

    }

    @Override
    public void queryByTime(List<Bill> billList, String startTime, String endTime) {
        // 时间格式化
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd");
        List<Bill> bills = billList.stream().filter(bill -> {
            String tmpTime = bill.getTime();
            try {
                // 将输入的时间字符串转换为格式化的 Date 类型
                Date tmpDate = simpleDateFormat.parse(tmpTime);
                Date startDate = simpleDateFormat.parse(startTime);
                Date endDate = simpleDateFormat.parse(endTime);
                // 将介于开始时间和结束时间的账单进行过滤
                if (tmpDate.before(endDate) && tmpDate.after(startDate)) {
                    return true;
                }
            } catch (ParseException parseException) {
                parseException.printStackTrace();
            }
            return false;
        }).collect(Collectors.toList());

        queryAll(bills);
    }


    @Override
    public void queryByType(List<Bill> billList, String type) {
        //1. 第一种方式，利用条件判断
        //for (Bill bill : billList) {
        //    if (bill.getType().equals(type)) {
        //        System.out.println(bill.getId() + "\t\t" + bill.getCategory() + "\t\t" + bill.getAccount() + "\t\t" + bill.getType() + "\t\t" + bill.getAmount() + "\t\t" + bill.getTime() + "\t\t" + bill.getDesc());
        //    }
        //}

        //2. 第二种方式，利用集合 Stream 流
        List<Bill> bills = billList.stream().filter(bill -> {
            String tmpType = bill.getType();
            return tmpType.equals(type);
        }).collect(Collectors.toList());
        queryAll(bills);
    }

    @Override
    public void modify(int id) {

    }
}
