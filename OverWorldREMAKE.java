import java.rmi.activation.UnknownGroupException;

import javax.lang.model.util.ElementScanner6;
import javax.swing.text.html.HTMLDocument.HTMLReader.SpecialAction;
import javax.xml.namespace.QName;

class OverWorldRemake {
    public static void main(String[]args) {//简介开始
        System.out.println("哎呀，太不幸了。你被一个飞上30楼的大卡车创死了，\n但好消息是在转世到异世界之前，你能对你自己进行详细定制！");
        System.out.println("规则：你将拥有50属性点，选择正面特质会消耗属性点，反之。\n请合理分配属性点，为自己的第二人生构建一个理想状态吧！");
        System.out.println("在每次选择后，都会显示你当前的属性点。");
        int RMpoint=50;//属性点
        System.out.print("你的名字：");
        String NameTho=In.getString();
        System.out.println("你的种族：魔族，亚人，人类，精灵，神裔");
        String spiece=In.getString();
        while(!"魔族".equals(spiece)&&!"亚人".equals(spiece)&&!"人类".equals(spiece)&&!"精灵".equals(spiece)&&!"神裔".equals(spiece)){
            System.out.println("请输入这五个其中一个种族:\n魔族，亚人，人类，精灵，神裔");
            spiece=In.getString();
        }
        int maxage=0;
        //种族年龄，特性设定
        if(spiece.equals("魔族")){
            RMpoint+=20;
            maxage=300;
        }
        else if (spiece.equals("亚人")){
            RMpoint+=10;
            maxage=80;
        }
        else if (spiece.equals("人类")){
            maxage=100;
        }
        else if (spiece.equals("精灵")){
            RMpoint-=25;
            maxage=(int)(Math.random()*400+350);
        }
        else if (spiece.equals("神裔")){
            RMpoint-=50;
            maxage=(int)(Math.random()*500+500);
        }
        //当前属性点
        System.out.println("目前属性点："+RMpoint);
        //性别选择
        System.out.println("你的性别：\n无性：你穿越的时候忘了什么东西。\n维持现状：就这样了 ，不换了。\n性转走起：这么好的机会必须试试另一种人生。\n双性人：小孩子才做选择，我全都要！\n乱马:你可以随意切换自己的性别，外貌也随之变化。");
        String Urgender=In.getString();
        while(!"无性".equals(Urgender)&&!"维持现状".equals(Urgender)&&!"性转走起".equals(Urgender)&&!"双性人".equals(Urgender)&&!"乱马".equals(Urgender)){
            System.out.println("请输入这五个其中一个性别:\n无性，维持现状，性转走起，双性人，乱马");
            Urgender=In.getString();
        }
        //性别特性
        if(Urgender.equals("无性")){
            RMpoint+=10;
            maxage+=10;//因为无性别，导不了，寿命+10
        }
        else if (Urgender.equals("维持现状")){
            RMpoint+=0;
        }
        else if (Urgender.equals("性转走起")){
            RMpoint-=5;
        }
        else if (Urgender.equals("双性人")){
            RMpoint-=15;
        }
        else if (Urgender.equals("乱马")){
            RMpoint-=30;
        }
        //当前属性点
        System.out.println("目前属性点："+RMpoint);
        System.out.println("世界局势(人类视角)\n炼狱：人类文明接近灭绝，魔族统领着大陆\n严酷：魔族四处横行，战乱永无止境，匪盗不计其数\n普通：魔族与人类势均力敌，彼此制衡，摩擦不断\n桃园：人类基本统治世界，偶尔有弱小的魔族出没作乱\n理想乡：和平持续千年，百姓安居乐业，彼此没有偏见");
        String Gamelvl=In.getString();
        while(!"炼狱".equals(Gamelvl)&&!"严酷".equals(Gamelvl)&&!"普通".equals(Gamelvl)&&!"桃园".equals(Gamelvl)&&!"理想乡".equals(Gamelvl)){
            System.out.println("请输入这五个其中一个难度:\n炼狱，严酷，普通，桃园，理想乡");
            Gamelvl=In.getString();
        }
        //难度特性
        if(Gamelvl.equals("炼狱")){
            if(spiece.equals("魔族")){
                RMpoint-=50;
            }
            else{
                RMpoint+=25;
            }
        }
        else if (Gamelvl.equals("严酷")){
            if(spiece.equals("魔族")){
                RMpoint-=25;
            }
            else{
                RMpoint+=10;
            }
        }
        else if (Gamelvl.equals("普通")){
        }
        else if (Gamelvl.equals("桃园")){
            if(spiece.equals("魔族")){
                RMpoint+=10;
            }
            else{
                RMpoint-=25;
            }
        }
        else if (Gamelvl.equals("理想乡")){
            if(spiece.equals("魔族")){
                RMpoint+=25;
            }
            else{
                RMpoint-=50;
            }
        }
        //当前属性点
        System.out.println("目前属性点："+RMpoint);
        System.out.println("基础属性");
        System.out.println("选择一个魔力亲和度：N，C-D，A-B，S或者R(Random)");
        char MagRating=In.getChar();
        if("精灵".equals(spiece)){
            while(MagRating!='C'&&MagRating!='A'&&MagRating!='B'&&MagRating!='S'&&MagRating!='R'){
                System.out.println("因为你是精灵族，只能选择C与以上的亲和度\n选择一个魔力亲和度：C，B，A，S或者R(Random)");
                MagRating=In.getChar();
            }
        }
        else if (spiece.equals("神裔")){
            while(MagRating!='C'&&MagRating!='A'&&MagRating!='B'&&MagRating!='S'&&MagRating!='R'){
                System.out.println("因为你是神裔，只能选择C与以上的亲和度\n选择一个魔力亲和度：C，B，A，S或者R(Random)");
                MagRating=In.getChar();
            }
        }
        else{
            while(MagRating!='N'&&MagRating!='C'&&MagRating!='D'&&MagRating!='A'&&MagRating!='B'&&MagRating!='S'&&MagRating!='R'){
                System.out.println("选择一个魔力亲和度：N，C-D，A-B，S或者R(Random)");
                MagRating=In.getChar();
           }
        }
        //魔力亲和度
        double diceMag = 1;
        if (MagRating=='S'){
            RMpoint-=50;
        }
        else if(MagRating=='A'||MagRating=='B'){
            RMpoint-=25;
        }
        else if (MagRating=='C'||MagRating=='D'){
            
        }
        else if (MagRating=='N'){
            RMpoint+=10;
        }
        else if (MagRating=='R'){
            //你选择了随机亲和度
            diceMag = (double)(Math.random()*10+0);
            if (diceMag<3.5&&!"精灵".equals(spiece)&&!"神裔".equals(spiece)){
                MagRating='N';
            }
            else if(diceMag<5.5&&!"精灵".equals(spiece)&&!"神裔".equals(spiece)){
                MagRating='D';
            }
            else if (diceMag<7.5){
                MagRating='C';
            }
            else if (diceMag<9.0){
                MagRating='B';
            }
            else if (diceMag<9.5){
                MagRating='A';
            }
            else if (diceMag<=10.0){
                MagRating='S';
            }
        }
        //当前属性点
        System.out.println("目前属性点："+RMpoint);
        //体质
        System.out.println("体质等级");
        System.out.println("选择一个体质等级：N，C-D，A-B，S或者R(Random)");
        char BodyRating=In.getChar();
        if (!"魔族".equals(spiece)){
            while(BodyRating!='N'&&BodyRating!='C'&&BodyRating!='D'&&BodyRating!='A'&&BodyRating!='B'&&BodyRating!='S'&&BodyRating!='R'){
                System.out.println("选择一个体质等级：N，C-D，A-B，S或者R(Random)");
                BodyRating=In.getChar();
            }
        }
        else if (spiece.equals("神裔")){
            while(BodyRating!='C'&&BodyRating!='A'&&BodyRating!='B'&&BodyRating!='S'&&BodyRating!='R'){
                System.out.println("因为你是神裔，只能选择C以上的等级\n选择一个体质等级：C，A，B，S或者R(Random)");
                BodyRating=In.getChar();
            }
        }
        else {
            while(BodyRating!='C'&&BodyRating!='D'&&BodyRating!='A'&&BodyRating!='B'&&BodyRating!='S'&&BodyRating!='R'){
                System.out.println("因为你是魔族，有保底体质\n选择一个体质等级：C-D，A-B，S或者R(Random)");
                BodyRating=In.getChar();
            }
        }
        double diceBody = 1;
        if (BodyRating=='S'){
            RMpoint-=50;
        }
        else if(BodyRating=='A'||BodyRating=='B'){
            RMpoint-=25;
        }
        else if (BodyRating=='C'||BodyRating=='D'){
            
        }
        else if (BodyRating=='N'){
            RMpoint+=10;
        }
        else if (BodyRating=='R'){
            //你选择了随机体质
            diceBody = (double)(Math.random()*10+0);
            if (diceBody<3.5&&!"魔族".equals(spiece)&&!"神裔".equals(spiece)){
                BodyRating='N';
            }
            else if(diceBody<5.5&&!"神裔".equals(spiece)){
                BodyRating='D';
            }
            else if (diceBody<7.5){
                BodyRating='C';
            }
            else if (diceBody<9.0){
                BodyRating='B';
            }
            else if (diceBody<9.5){
                BodyRating='A';
            }
            else if (diceBody<=10.0){
                BodyRating='S';
            }
        }
        //当前属性点
        System.out.println("目前属性点："+RMpoint);
        System.out.println("智力天赋");
        System.out.println("选择一个智力天赋：N，C-D，A-B，S或者R(Random)");
        char IQRating=In.getChar();
        if (!"人类".equals(spiece)){
            while(IQRating!='N'&&IQRating!='C'&&IQRating!='D'&&IQRating!='A'&&IQRating!='B'&&IQRating!='S'&&IQRating!='R'){
                System.out.println("选择一个智力天赋：N，C-D，A-B，S或者R(Random)");
                IQRating=In.getChar();
            }//智力
        }
        else if (spiece.equals("神裔")){
            while(IQRating!='C'&&IQRating!='A'&&IQRating!='B'&&IQRating!='S'&&IQRating!='R'){
                System.out.println("因为你是神裔，只能选择C以上的等级\n选择一个智力天赋：C，A，B，S或者R(Random)");
                IQRating=In.getChar();
            }
        }
        else {
            while(IQRating!='C'&&IQRating!='D'&&IQRating!='A'&&IQRating!='B'&&IQRating!='S'&&IQRating!='R'){
                System.out.println("因为你是人族，有保底D级\n选择一个智力天赋：C-D，A-B，S或者R(Random)");
                IQRating=In.getChar();
            }
        }
        double diceIQ = 1;
        if (IQRating=='S'){
            RMpoint-=50;
        }
        else if(IQRating=='A'||IQRating=='B'){
            RMpoint-=25;
        }
        else if (IQRating=='C'||IQRating=='D'){
            
        }
        else if (IQRating=='N'){
            RMpoint+=10;
        }
        else if (IQRating=='R'){
            //你选择了随机智力天赋
            diceIQ = (double)(Math.random()*10+0);
            if (diceIQ<3.5&&!"人类".equals(spiece)&&!"神裔".equals(spiece)){
                IQRating='N';
            }
            else if(diceIQ<5.5&&!"神裔".equals(spiece)){
                IQRating='D';
            }
            else if (diceIQ<7.5){
                IQRating='C';
            }
            else if (diceIQ<9.0){
                IQRating='B';
            }
            else if (diceIQ<9.5){
                IQRating='A';
            }
            else if (diceIQ<=10.0){
                IQRating='S';
            }
        }
        //当前属性点
        System.out.println("目前属性点："+RMpoint);
        System.out.println("初始运气 \n选择一个初始运气：N，C-D，A-B，S或者R(Random)");
        char LuckRating=In.getChar();
        while(LuckRating=='N'&&LuckRating=='D'&&LuckRating=='C'&&LuckRating=='B'&&LuckRating=='A'&&LuckRating=='S'&&LuckRating=='R'){
            System.out.println("选择其中一个初始运气：N，C-D，A-B，S或者R(Random)");
        LuckRating=In.getChar();
        }
        double diceLuck=1;
        if (LuckRating=='S'){
            RMpoint-=50;
        }
        else if(LuckRating=='A'||LuckRating=='B'){
            RMpoint-=25;
        }
        else if (LuckRating=='C'||LuckRating=='D'){
            
        }
        else if (LuckRating=='N'){
            RMpoint+=10;
        }
        else if (LuckRating=='R'){
            //你选择了随机智力天赋
            diceLuck= (double)(Math.random()*10+0);
            if (diceLuck<3.5){
                LuckRating='N';
            }
            else if(diceLuck<5.5){
                LuckRating='D';
            }
            else if (diceLuck<7.5){
                LuckRating='C';
            }
            else if (diceLuck<9.0){
                LuckRating='B';
            }
            else if (diceLuck<9.5){
                LuckRating='A';
            }
            else if (diceLuck<=10.0){
                LuckRating='S';
            }
        }
        if (spiece.equals("魔族")){
            System.out.println("选择你在魔族里面的种族");
            spiece=In.getString();
        }
        else if (spiece.equals("亚人")){
            System.out.println("选择你在亚人里面的种族");
            spiece=In.getString();
        }
        System.out.println("姓名："+NameTho+"\n你的种族: "+spiece+"\n你的性别："+Urgender+"\n魔力亲和度："+MagRating+"\n体质："+BodyRating+"\n智力："+IQRating+"\n运气："+LuckRating+"\n难度："+Gamelvl);
        System.out.println("当前最高寿命："+maxage+"\n魔力随机："+diceMag+"\n体质随机："+diceBody+"\n智力随机："+diceIQ+"\n运气随机："+diceLuck);
    }
}