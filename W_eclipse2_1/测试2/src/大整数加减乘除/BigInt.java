/**
 * 文件名：BigInt.java
 * 项目-包：测试2 - 测试
 * 作者：张文迪
 * 创建日期：2014-9-1
 */
package 大整数加减乘除;

/**
 * @author 张文迪
 * 类名：BigInt
 * 类说明：
 */
import java.util.Scanner;

public class BigInt {

 private boolean isPositive=true;//true表示是正数
 private String number="0";//数的绝对值部分
 public BigInt() {
 }
 /**
  * 构造函数
  * @param number 数字字符串，若为负数，前面加负号-
  */
 public BigInt(String number) {
  String flag=number.substring(0, 1);
  if(flag.equals("-")){
   this.isPositive=false;
   this.number=number.substring(1);
  }else{
   this.isPositive=true;
   this.number = number;
  }  
 }
 /**
  * 比较两个数字字符串所表示数字的大小
  * @param a 要比较的数字字符串所表示数字
  * @param b 要比较的数字字符串所表示数字
  * @return 若a>b,则返回正数，若a=b,则返回0,若a<b则返回负数
  */
 private int compare(String a,String b){
  int MaxLen=0;
  if(a.length()>=b.length()){
   MaxLen=a.length();
   while(b.length()<MaxLen){
    b="0"+b;
   }
  }else{
   MaxLen=b.length();
   while(a.length()<MaxLen){
    a="0"+a;
   }
  }
  if(a.compareTo(b)>0)
   return 1;
  else if(a.compareTo(b)==0)
   return 0;
  else
   return -1;
 }
 /**
  * 加法
  * @param bigint
  * @return
  */
 public BigInt add(BigInt bigint){
  BigInt bi=new BigInt();
  String a=this.number;
  String b=bigint.number;
  if((this.isPositive&&bigint.isPositive)||(!this.isPositive&&!bigint.isPositive)){//同符号
   bi.isPositive=this.isPositive;
   bi.number=absAdd(a,b);
  }else{
   if(compare(a,b)>0){
    bi.isPositive=this.isPositive;
    bi.number=absSub(a,b);
   }else if(compare(a,b)==0){
    bi.isPositive=true;
    bi.number="0";
   }else{
    bi.isPositive=bigint.isPositive;
    bi.number=absSub(a,b);
   }
  }
  return bi;
 }
 /**
  * 减法
  * @param bigint
  * @return
  */
 public BigInt sub(BigInt bigint){
  BigInt bi=new BigInt();
  String a=this.number;
  String b=bigint.number;
  if((this.isPositive&&bigint.isPositive)||(!this.isPositive&&!bigint.isPositive)){//同符号
   if(compare(a,b)>0){
    bi.isPositive=this.isPositive;
    bi.number=absSub(a,b);
   }else if(compare(a,b)==0){
     bi.isPositive=true;
     bi.number="0";
   }else{
    bi.isPositive=!bigint.isPositive;
    bi.number=absSub(a,b);
   }
  }else{
   bi.isPositive=this.isPositive;
   bi.number=absAdd(a,b);
  }
  return bi;
 }
 /**
  * 乘法
  * @param bigint
  * @return
  */
 public BigInt multi(BigInt bigint){
  BigInt bi=new BigInt();
  String a=this.number;
  String b=bigint.number;
  if(a.equals("0")||b.equals("0")){
   bi.isPositive=true;
   bi.number="0";
  }else if((this.isPositive&&bigint.isPositive)||(!this.isPositive&&!bigint.isPositive)){//同号
   bi.isPositive=true;
   bi.number=absMulti(a,b);
  }else{//异号
   bi.isPositive=false;
   bi.number=absMulti(a,b);
  }
  return bi;
 }
 /**
  * 除法（整除，返回整数商）
  * @param bigint
  * @return
  */
 public BigInt div(BigInt bigint){
  BigInt bi=new BigInt();
  String a=this.number;
  String b=bigint.number;
  if(a.equals("0")||b.equals("0")){
   bi.isPositive=true;
   bi.number="0";
  }else if((this.isPositive&&bigint.isPositive)||(!this.isPositive&&!bigint.isPositive)){//同号
   bi.isPositive=true;
   bi.number=absDiv(a,b);
  }else{//异号
   bi.isPositive=false;
   bi.number=absDiv(a,b);
  }
  return bi;
 }
 /**
  * 取余
  * @param bigint
  * @return
  */
 public BigInt mod(BigInt bigint){
  BigInt bi=new BigInt();
  String a=this.number;
  String b=bigint.number;
  if(a.equals("0")||b.equals("0")){
   bi.isPositive=true;
   bi.number="0";
  }else if((this.isPositive&&bigint.isPositive)||(!this.isPositive&&!bigint.isPositive)){//同号
   bi.isPositive=true;
   bi.number=absMod(a,b);
  }else{//异号
   bi.isPositive=false;
   bi.number=absMod(a,b);
  }
  return bi;
 }
 /**
  * 绝对值想加
  * @param a
  * @param b
  * @return 返回想加和
  */
 private String absAdd(String a, String b) {
  int MaxLen=0;
  if(a.length()>=b.length()){
   MaxLen=a.length();
   while(b.length()<MaxLen){
    b="0"+b;
   }
  }else{
   MaxLen=b.length();
   while(a.length()<MaxLen){
    a="0"+a;
   }
  }
  String str = "";
  int JW = 0;// 进位
  for (int i = MaxLen - 1; i >= 0; i--) {
   int tempA = a.charAt(i)-'0';
   int tempB = b.charAt(i)-'0';
   int temp;
   if (tempA + tempB + JW >= 10 && i != 0) {
    temp = tempA + tempB + JW - 10;
    JW = 1;
   } else {
    temp = tempA + tempB + JW;
    JW = 0;
   }
   str = String.valueOf(temp) + str;
  }
  while(str.length()>1&&str.charAt(0)=='0'){
   str=str.substring(1);
  }
  return str;
 }
 /**
  * 绝对值相减，参数不分大小先后，取大减小
  * @param a
  * @param b
  * @return 返回两绝对值的差的绝对值，
  */
 private String absSub(String a, String b) {
  int MaxLen=0;
  if(a.length()>=b.length()){
   MaxLen=a.length();
   while(b.length()<MaxLen){
    b="0"+b;
   }
  }else{
   MaxLen=b.length();
   while(a.length()<MaxLen){
    a="0"+a;
   }
  }
  if(a.compareTo(b)<0){
   String temp=a;
   a=b;
   b=temp;
  }
  String str = "";
  int JW = 0;// 借位
  for (int i = MaxLen - 1; i >= 0; i--) {
   int tempA = a.charAt(i)-'0';
   int tempB = b.charAt(i)-'0';
   int temp;
   if (tempA - JW - tempB < 0 && i != 0) {
    temp = tempA + 10 - JW - tempB;
    JW = 1;
   } else {
    temp = tempA - JW - tempB;
    JW = 0;
   }
   str = temp + str;
  }
  while(str.length()>1&&str.charAt(0)=='0'){
   str=str.substring(1);
  }
  return str;
 }
 /**
  * 绝对值相乘
  * @param a
  * @param b
  * @return
  */
 private String absMulti(String a,String b){
  String result="0";
  if(a.equals("0")||b.equals("0"))
   return "0";
     for(int i = b.length()-1; i >=0; i--){
      int plustimes=b.charAt(i)-'0';
      String atemp=a;
      for(int j=1;j<=b.length()-1-i;j++){
       atemp=atemp+"0";
      }
      for(int m=1;m<=plustimes;m++){
       result=absAdd(result,atemp);
      }
     }
  return result;
 }
 /**
  * 绝对值相除，
  * @param a 被除数
  * @param b 除数
  * @return
  */
 private String absDiv(String a,String b){
  if(a.equals("0")||b.equals("0"))
   return "0";
  String result="";
  String dealnum="";
  String left="";
  for(int index=0;index<a.length();index++){  
   dealnum=left+a.substring(index,index+1);
   while(left.length()>1&&left.charAt(0)=='0'){
    left=left.substring(1);
   }
   while(dealnum.length()>1&&dealnum.charAt(0)=='0'){
    dealnum=dealnum.substring(1);
   }
   if(compare(dealnum,b)<0){
    result+="0";
    left=dealnum;
    continue;
   }else if(compare(dealnum,b)==0){
    result+="1";
    left="0";
   }else{
    for(int i=9;i>=0;i--){
     String s=absMulti(String.valueOf(i),b);
     if(compare(s,dealnum)>0){
      continue;
     }else if(compare(s,dealnum)==0){
      result+=String.valueOf(i);
      left="0";
      break;
     }else{
      result+=String.valueOf(i);
      left=absSub(s,dealnum);
      break;
     }
    }
   }
  }
  while(result.length()>1&&result.charAt(0)=='0'){
   result=result.substring(1);
  }
  return result;
 }
 /**
  * 绝对值取余
  * @param a 被除数
  * @param b 除数
  * @return
  */
 private String absMod(String a,String b){
  if(a.equals("0")||b.equals("0"))
   return "0";
  String result="";
  String dealnum="";
  String left="";
  for(int index=0;index<a.length();index++){  
   dealnum=left+a.substring(index,index+1);
   while(left.length()>1&&left.charAt(0)=='0'){
    left=left.substring(1);
   }
   while(dealnum.length()>1&&dealnum.charAt(0)=='0'){
    dealnum=dealnum.substring(1);
   }
   if(compare(dealnum,b)<0){
    result+="0";
    left=dealnum;
    continue;
   }else if(compare(dealnum,b)==0){
    result+="1";
    left="0";
   }else{
    for(int i=9;i>=0;i--){
     String s=absMulti(String.valueOf(i),b);
     if(compare(s,dealnum)>0){
      continue;
     }else if(compare(s,dealnum)==0){
      result+=String.valueOf(i);
      left="0";
      break;
     }else{
      result+=String.valueOf(i);
      left=absSub(s,dealnum);
      break;
     }
    }
   }
  }
  while(left.length()>1&&left.charAt(0)=='0'){
   left=left.substring(1);
  }
  return left;
 }
 /**
  * 以整数形式输出大整数
  */
 public String toString(){
  if(this.number.equals("0")){
   return this.number;
  }
  String str=this.isPositive?"":"-"; 
  str=str+this.number;
  return str;
 }
 public static void main(String[] args) {
  while(true){
   String reg="^-?[1-9]\\d*$";//判断是整数的正则表达式
   System.out.println("输入第一个大数据：");
    Scanner scan=new Scanner(System.in);
   String a=scan.nextLine(); 
   if(!a.matches(reg)){
    System.out.println("非整数字串！");
    continue;
   }
   System.out.println("输入第二个大数据：");
   String b=scan.nextLine(); 
   if(!b.matches(reg)){
    System.out.println("非整数字串！");
    continue;
   }
   BigInt bigintA=new BigInt(a);
   BigInt bigintB=new BigInt(b);
   BigInt result=bigintA.add(bigintB); 
   System.out.println("加法结果："+result.toString()); 
   BigInt result1=bigintA.sub(bigintB);
   System.out.println("减法结果："+result1.toString());
   BigInt result3=bigintA.multi(bigintB);
   System.out.println("乘法结果："+result3.toString());
   BigInt result4=bigintA.div(bigintB);
   System.out.println("除法结果："+result4.toString());
   BigInt result5=bigintA.mod(bigintB);
   System.out.println("余数结果："+result5.toString());
  }
 }

}