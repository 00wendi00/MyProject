/**
 * �ļ�����BigInt.java
 * ��Ŀ-��������2 - ����
 * ���ߣ����ĵ�
 * �������ڣ�2014-9-1
 */
package �������Ӽ��˳�;

/**
 * @author ���ĵ�
 * ������BigInt
 * ��˵����
 */
import java.util.Scanner;

public class BigInt {

 private boolean isPositive=true;//true��ʾ������
 private String number="0";//���ľ���ֵ����
 public BigInt() {
 }
 /**
  * ���캯��
  * @param number �����ַ�������Ϊ������ǰ��Ӹ���-
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
  * �Ƚ����������ַ�������ʾ���ֵĴ�С
  * @param a Ҫ�Ƚϵ������ַ�������ʾ����
  * @param b Ҫ�Ƚϵ������ַ�������ʾ����
  * @return ��a>b,�򷵻���������a=b,�򷵻�0,��a<b�򷵻ظ���
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
  * �ӷ�
  * @param bigint
  * @return
  */
 public BigInt add(BigInt bigint){
  BigInt bi=new BigInt();
  String a=this.number;
  String b=bigint.number;
  if((this.isPositive&&bigint.isPositive)||(!this.isPositive&&!bigint.isPositive)){//ͬ����
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
  * ����
  * @param bigint
  * @return
  */
 public BigInt sub(BigInt bigint){
  BigInt bi=new BigInt();
  String a=this.number;
  String b=bigint.number;
  if((this.isPositive&&bigint.isPositive)||(!this.isPositive&&!bigint.isPositive)){//ͬ����
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
  * �˷�
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
  }else if((this.isPositive&&bigint.isPositive)||(!this.isPositive&&!bigint.isPositive)){//ͬ��
   bi.isPositive=true;
   bi.number=absMulti(a,b);
  }else{//���
   bi.isPositive=false;
   bi.number=absMulti(a,b);
  }
  return bi;
 }
 /**
  * ���������������������̣�
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
  }else if((this.isPositive&&bigint.isPositive)||(!this.isPositive&&!bigint.isPositive)){//ͬ��
   bi.isPositive=true;
   bi.number=absDiv(a,b);
  }else{//���
   bi.isPositive=false;
   bi.number=absDiv(a,b);
  }
  return bi;
 }
 /**
  * ȡ��
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
  }else if((this.isPositive&&bigint.isPositive)||(!this.isPositive&&!bigint.isPositive)){//ͬ��
   bi.isPositive=true;
   bi.number=absMod(a,b);
  }else{//���
   bi.isPositive=false;
   bi.number=absMod(a,b);
  }
  return bi;
 }
 /**
  * ����ֵ���
  * @param a
  * @param b
  * @return ������Ӻ�
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
  int JW = 0;// ��λ
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
  * ����ֵ������������ִ�С�Ⱥ�ȡ���С
  * @param a
  * @param b
  * @return ����������ֵ�Ĳ�ľ���ֵ��
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
  int JW = 0;// ��λ
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
  * ����ֵ���
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
  * ����ֵ�����
  * @param a ������
  * @param b ����
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
  * ����ֵȡ��
  * @param a ������
  * @param b ����
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
  * ��������ʽ���������
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
   String reg="^-?[1-9]\\d*$";//�ж���������������ʽ
   System.out.println("�����һ�������ݣ�");
    Scanner scan=new Scanner(System.in);
   String a=scan.nextLine(); 
   if(!a.matches(reg)){
    System.out.println("�������ִ���");
    continue;
   }
   System.out.println("����ڶ��������ݣ�");
   String b=scan.nextLine(); 
   if(!b.matches(reg)){
    System.out.println("�������ִ���");
    continue;
   }
   BigInt bigintA=new BigInt(a);
   BigInt bigintB=new BigInt(b);
   BigInt result=bigintA.add(bigintB); 
   System.out.println("�ӷ������"+result.toString()); 
   BigInt result1=bigintA.sub(bigintB);
   System.out.println("���������"+result1.toString());
   BigInt result3=bigintA.multi(bigintB);
   System.out.println("�˷������"+result3.toString());
   BigInt result4=bigintA.div(bigintB);
   System.out.println("���������"+result4.toString());
   BigInt result5=bigintA.mod(bigintB);
   System.out.println("���������"+result5.toString());
  }
 }

}