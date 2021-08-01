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
 * @className : MainApp
 * @createTime : 2021/8/1 7:22
 * @email : 747731461@qq.com
 * @公众号 : 村雨遥
 * @website : https://cunyu1943.github.io
 * @description :
 */
public class MainApp {
    static List<Bill> billList = new ArrayList<>();

    static {
        billList.add(new Bill(1, "购物", "支付宝", "支出", 13000, "2021-08-01", "Macbook Pro 13"));
        billList.add(new Bill(2, "工资", "银行卡", "收入", 15000, "2021-08-01", "8 月份工资"));
    }

    public static void main(String[] args) {
        // 创建输入器
        Scanner scanner = new Scanner(System.in);
        Bill bill = new Bill();
        // 标志位，是否退出系统
        boolean flag = true;
        while (flag) {
            System.out.println("----------欢迎使用记账系统--------");
            System.out.println("----------【1】添加账务----------");
            System.out.println("----------【2】删除账务----------");
            System.out.println("----------【3】修改账务----------");
            System.out.println("----------【4】查询账务----------");
            System.out.println("----------【0】退出-------------");

            System.out.println("请输入功能序号【0-4】");

            String choice = scanner.next();

            switch (choice) {
                case "1":
                    System.out.println("添加账务");
                    System.out.println("请输入 id");
                    int id = scanner.nextInt();
                    bill.setId(id);
                    System.out.println("请输入账务类别");
                    String category = scanner.next();
                    bill.setCategory(category);
                    System.out.println("请输入账户");
                    String account = scanner.next();
                    bill.setAccount(category);
                    System.out.println("请输入类型（收入/支出）");
                    String type = scanner.next();
                    bill.setType(type);
                    System.out.println("请输入金额");
                    double amount = scanner.nextDouble();
                    bill.setAmount(amount);
                    System.out.println("请输入时间");
                    String time = scanner.next();
                    bill.setTime(time);
                    System.out.println("请输入备注");
                    String description = scanner.nextLine();
                    bill.setDesc(description);
                    break;
                case "2":
                    System.out.println("删除账务");
                    break;
                case "3":
                    System.out.println("修改账务>>");

                    break;
                case "4":
                    System.out.println("查询账务 >>");
                    System.out.println("1. 查询所有\t\t 2. 按时间区间\t\t 3. 按类型（收入/支出）");
                    System.out.println("输入你的选择");
                    int option = scanner.nextInt();

                    switch (option) {
                        case 1:
                            System.out.println(">> 所有账务");
                            System.out.println("ID\t\t类别\t\t\t账户\t\t类型\t\t金额\t\t\t时间\t\t\t\t备注");
                            bill.queryAll(billList);
                            break;
                        case 2:
                            System.out.println(">> 按时间区间账务");
                            System.out.println("ID\t\t类别\t\t\t账户\t\t类型\t\t金额\t\t\t时间\t\t\t\t备注");
                            System.out.println("请输入开始时间（格式：2011-01-01）");
                            String startTime = scanner.next();
                            System.out.println("请输入结束时间（格式：2011-01-01）");
                            String endTime = scanner.next();
                            bill.queryByTime(billList, startTime, endTime);
                            break;
                        case 3:
                            System.out.println(">> 按类型");
                            System.out.println("请输入查询类型（收入/支出）");
                            type = scanner.next();
                            System.out.println("ID\t\t类别\t\t\t账户\t\t类型\t\t金额\t\t\t时间\t\t\t\t备注");
                            bill.queryByType(billList, type);
                    }
                    break;
                case "0":
                    flag = false;
                    break;
                default:
                    System.out.println("请重新输入");
                    break;
            }
        }
        System.out.println("退出系统，期待下次见面 ~");
    }
}
