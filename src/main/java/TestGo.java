
import org.junit.Test;

import java.util.HexFormat;


public class TestGo {

    @Test
    public void TestPkcs7(){
        String content = "豫章故郡，洪都新府。星分翼轸，地接衡庐。襟三江而带五湖，控蛮荆而引瓯越。物华天宝，龙光射牛斗之墟；人杰地灵，徐孺下陈蕃之榻。雄州雾列，俊采星驰。台隍枕夷夏之交，宾主尽东南之美。都督阎公之雅望，棨戟遥临；宇文新州之懿范，襜帷暂驻。十旬休假，胜友如云；千里逢迎，高朋满座。腾蛟起凤，孟学士之词宗；紫电青霜，王将军之武库。家君作宰，路出名区；童子何知，躬逢胜饯。\n" +
                "\n" +
                "时维九月，序属三秋。潦水尽而寒潭清，烟光凝而暮山紫。俨骖騑于上路，访风景于崇阿；临帝子之长洲，得天人之旧馆。层峦耸翠，上出重霄；飞阁流丹，下临无地。鹤汀凫渚，穷岛屿之萦回；桂殿兰宫，即冈峦之体势。\n" +
                "\n" +
                "披绣闼，俯雕甍，山原旷其盈视，川泽纡其骇瞩。闾阎扑地，钟鸣鼎食之家；舸舰弥津，青雀黄龙之舳。云销雨霁，彩彻区明。落霞与孤鹜齐飞，秋水共长天一色。渔舟唱晚，响穷彭蠡之滨；雁阵惊寒，声断衡阳之浦。\n" +
                "\n" +
                "遥襟甫畅，逸兴遄飞。爽籁发而清风生，纤歌凝而白云遏。睢园绿竹，气凌彭泽之樽；邺水朱华，光照临川之笔。四美具，二难并。穷睇眄于中天，极娱游于暇日。天高地迥，觉宇宙之无穷；兴尽悲来，识盈虚之有数。望长安于日下，目吴会于云间。地势极而南溟深，天柱高而北辰远。关山难越，谁悲失路之人？萍水相逢，尽是他乡之客。怀帝阍而不见，奉宣室以何年？\n" +
                "\n" +
                "嗟乎！时运不齐，命途多舛。冯唐易老，李广难封。屈贾谊于长沙，非无圣主；窜梁鸿于海曲，岂乏明时？所赖君子见机，达人知命。老当益壮，宁移白首之心？穷且益坚，不坠青云之志。酌贪泉而觉爽，处涸辙以犹欢。北海虽赊，扶摇可接；东隅已逝，桑榆非晚。孟尝高洁，空余报国之情；阮籍猖狂，岂效穷途之哭！\n" +
                "\n" +
                "勃，三尺微命，一介书生。无路请缨，等终军之弱冠；有怀投笔，慕宗悫之长风。舍簪笏于百龄，奉晨昏于万里。非谢家之宝树，接孟氏之芳邻。他日趋庭，叨陪鲤对；今兹捧袂，喜托龙门。杨意不逢，抚凌云而自惜；钟期既遇，奏流水以何惭？\n" +
                "\n" +
                "呜乎！胜地不常，盛筵难再；兰亭已矣，梓泽丘墟。临别赠言，幸承恩于伟饯；登高作赋，是所望于群公。敢竭鄙怀，恭疏短引；一言均赋，四韵俱成。请洒潘江，各倾陆海云尔：\n" +
                "\n" +
                "滕王高阁临江渚，佩玉鸣鸾罢歌舞。\n" +
                "\n" +
                "画栋朝飞南浦云，珠帘暮卷西山雨。\n" +
                "\n" +
                "闲云潭影日悠悠，物换星移几度秋。\n" +
                "\n" +
                "阁中帝子今何在？槛外长江空自流。";
        String cert = "{\"PrivKey\":\"aa5c9d2c1199ae787359c35078add0d71e9b02002ffb7f4df9f767db1aa2c224\",\"PubKey\":\"0098a1175ab14ebcb176f3510b1ed013481bc9438175a5b0d5bdf484641a4580c6\",\"CertStr\":\"LS0tLS1CRUdJTiBDRVJUSUZJQ0FURS0tLS0tCk1JSURIakNDQXNTZ0F3SUJBZ0lCL3pBS0JnZ3FnUnpQVlFHRGRUQThNUTB3Q3dZRFZRUUtFd1JVUlZOVU1RMHcKQ3dZRFZRUURFd1JqWlhKME1ROHdEUVlEVlFRcUV3WkhiM0JvWlhJeEN6QUpCZ05WQkFZVEFrNU1NQ0FYRFRJegpNVEl5T1RBM01UWXpNVm9ZRHpJeE1qRXhNREV3TVRJd01UQXhXakE4TVEwd0N3WURWUVFLRXdSVVJWTlVNUTB3CkN3WURWUVFERXdSalpYSjBNUTh3RFFZRFZRUXFFd1pIYjNCb1pYSXhDekFKQmdOVkJBWVRBazVNTUZrd0V3WUgKS29aSXpqMENBUVlJS29FY3oxVUJnaTBEUWdBRW1LRVhXckZPdkxGMjgxRUxIdEFUU0J2SlE0RjFwYkRWdmZTRQpaQnBGZ01iamhrT2ZrdlZsUURhVUlGUTFPZjcvRkpRR2pWZEoyeWhXY3JTOWx0T3FnS09DQWJNd2dnR3ZNQTRHCkExVWREd0VCL3dRRUF3SUNCREFtQmdOVkhTVUVIekFkQmdnckJnRUZCUWNEQWdZSUt3WUJCUVVIQXdFR0Fpb0QKQmdPQkN3RXdEd1lEVlIwVEFRSC9CQVV3QXdFQi96QmZCZ2dyQmdFRkJRY0JBUVJUTUZFd0l3WUlLd1lCQlFVSApNQUdHRjJoMGRIQTZMeTl2WTNOd0xtVjRZVzF3YkdVdVkyOXRNQ29HQ0NzR0FRVUZCekFDaGg1b2RIUndPaTh2ClkzSjBMbVY0WVcxd2JHVXVZMjl0TDJOaE1TNWpjblF3UmdZRFZSMFJCRDh3UFlJUWRHVnpkQzVsZUdGdGNHeGwKTG1OdmJZRVJaMjl3YUdWeVFHZHZiR0Z1Wnk1dmNtZUhCSDhBQUFHSEVDQUJTR0FBQUNBQkFBQUFBQUFBQUdndwpEd1lEVlIwZ0JBZ3dCakFFQmdJcUF6QXFCZ05WSFI0RUl6QWhvQjh3RG9JTUxtVjRZVzF3YkdVdVkyOXRNQTJDCkMyVjRZVzF3YkdVdVkyOXRNRmNHQTFVZEh3UlFNRTR3SmFBam9DR0dIMmgwZEhBNkx5OWpjbXd4TG1WNFlXMXcKYkdVdVkyOXRMMk5oTVM1amNtd3dKYUFqb0NHR0gyaDBkSEE2THk5amNtd3lMbVY0WVcxd2JHVXVZMjl0TDJOaApNUzVqY213d0ZnWURLZ01FQkE5bGVIUnlZU0JsZUhSbGJuTnBiMjR3RFFZRFZSME9CQVlFQkFRREFnRXdDZ1lJCktvRWN6MVVCZzNVRFNBQXdSUUlnRzBUMzdhL1ZIRUdsOTRkRmVBUVBFUm5LZ0JDdEl1Y2VDYS94akZPZTBPc0MKSVFDVEgvUWNqd3AvNklSK0xSd2JIaHVYVXRTcXEwbGQ1bFJMSEFybWlFVGV1UT09Ci0tLS0tRU5EIENFUlRJRklDQVRFLS0tLS0K\"}";
        System.out.println("加密 =========================================");
        String result = Pkcs7.INSTANCE.Encrypt(content.getBytes(),content.getBytes().length,cert.getBytes(),cert.getBytes().length);
        byte[] bytes =  HexFormat.of().parseHex(result);
        System.out.println("EncryptResult16进制:"+result);
        String str = new String(bytes);
        System.out.println("EncryptResultStr:"+str);

        System.out.println("解密 =========================================");
        String decrypRresult = Pkcs7.INSTANCE.Decrypt(bytes,bytes.length,cert.getBytes(),cert.getBytes().length);
        byte[] decrypbytes =  HexFormat.of().parseHex(decrypRresult);
        System.out.println("DecryptResult16进制:"+decrypRresult);
        String decryptstr = new String(decrypbytes);
        System.out.println("DecryptResultStr:"+decryptstr);
    }
}
