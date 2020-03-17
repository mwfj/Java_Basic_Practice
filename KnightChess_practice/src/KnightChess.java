import java.util.*;

public class KnightChess {

	static int player1;// 角色1
	static int player2;// 角色2
	static int[] map = new int[100];// 地图
	static String[] goAndstop = new String[2];// 记录玩家当前的位置
	static String[] playerName = new String[2]; // 对战角色
	static int[] luckyTurn = { 6, 23, 40, 55, 69, 83 }; // 幸运轮盘
	static int[] landMine = { 5, 13, 17, 33, 38, 50, 64, 80, 94 }; // 地雷位置
	static int[] pause = { 9, 27, 60, 93 }; // 暂停
	static int[] timeTunnel = { 20, 25, 45, 63, 72, 88, 90 }; // 时空隧道

	// *******************************************************************************
	// 绘制地图
	public static void createMap() {
		int i = 0;

		// 在对战地图上设置幸运轮盘
		for (i = 0; i < luckyTurn.length; i++) {
			map[luckyTurn[i]] = 1;
		}
		// 在对战地图上设置时空隧道
		for (i = 0; i < timeTunnel.length; i++) {
			map[timeTunnel[i]] = 2;
		}
		// 在对战地图上设置地雷
		for (i = 0; i < landMine.length; i++) {
			map[landMine[i]] = 3;
		}

		// 在对战地图上设置暂停
		for (i = 0; i < pause.length; i++) {
			map[pause[i]] = 4;
		}

	}

	public static void showMap(int playRole1, int playRole2) {
		showLine1(0, 31, playRole1, playRole2); // 显示地图第一行
		System.out.println(); // 换行
		showRLine(31, 35, playRole1, playRole2); // 显示地图右竖行
		showLine2(35, 66, playRole1, playRole2); // 显示地图第二行
		System.out.println(); // 换行
		showLLine(66, 69, playRole1, playRole2); // 显示地图左竖行
		showLine3(69, 100, playRole1, playRole2); // 显示地图第3行
	}

	public static String getGraphic(int i, int index, int playRole1,
			int playRole2) {
		String graphic = "";
		if (playRole1 == index &&playRole2 == index) {
			graphic = "!!";
		} else if (playRole1 == index) {
			graphic = "A";
		} else if (playRole2 == index) {
			graphic = "B";

		} else {
			switch (i) {
			case 1:// 幸运转盘
				graphic = "¤";
				break;
			case 2:// 时空隧道
				graphic = "〓";
				break;
			case 3:// 地雷
				graphic = "※";
				break;
			case 4:// 暂停
				graphic = "■";
				break;
			default:// 普通
				graphic = "∷";
				break;
			}
		}
		return graphic;
	}

	public static void showLine1(int begin, int end, int playRole1,
			int playRole2) {
		// 输出地图第一行
		for (int i = begin; i < end; i++) {

			System.out.print(getGraphic(map[i], i, playRole1, playRole2));

		}
	}

	public static void showLine2(int begin, int end, int playRole1,
			int playRole2) {
		// 输出地图第二行
		for (int i = end - 1; i >= begin; i--) {
			System.out.print(getGraphic(map[i], i, playRole1, playRole2));

		}
	}

	public static void showLine3(int begin, int end, int playRole1,int playRole2) {
		// 输出地图第三行
		for (int i = begin; i < end; i++) {
			System.out.print(getGraphic(map[i], i, playRole1, playRole2));

		}
	}

	public static void showLLine(int begin, int end, int playRole1,int playRole2) {
		// 输出地图的左竖行
		for (int i = begin; i < end; i++) {
			System.out.println(getGraphic(map[i], i, playRole1, playRole2));
		}
	}
	public static void print(String s) {
		System.out.println(s);
	}
	public static void showRLine(int begin, int end, int playRole1,
			int playRole2) {
		// 输出地图右竖行
		for (int i = begin; i < end; i++) {
			for (int j = 0; j < 44; j++) {
				System.out.printf("  ");
			}
			System.out.println(getGraphic(map[i], i, playRole1, playRole2));
		}

	}

	// 绘图结束
	// **********************************************************************************

	// **********************************************************************************
	// 设置游戏
	public static void setGame() {
		// 初始化游戏
		player1 = 0;
		player2 = 0;
		goAndstop[0] = "on";
		goAndstop[1] = "on";
	}

	public static void setRole(int note, int playRole) {
		// 设置人物
		switch (playRole) {
		case 1:
			playerName[note-1] = "希特勒";
			break;
		case 2:
			playerName[note-1] = "斯大林";
			break;
		case 3:
			playerName[note-1] = "克林顿";
			break;
		case 4:
			playerName[note-1] = "巴顿";
			break;
		default:
			break;
		}
	}

	public static int gameRules(int note, int position, int step) {
		// 游戏的规则，即游戏细节
		position += step;
		if (position >= 99) {
			return position;
		}
		Scanner scanner = new Scanner(System.in);

		switch (map[position]) {
		case 0:// 当走到普通的格子时候
				// 如果两个人同时在同一个位置，那么后一个人留在该位置，前一个人回到起点
			if (note == 1 && player2 == position) {
				player2 = 0;
				System.out.println("抱歉，你被踩回原点了");
			} else if (note == 2 && player1 == position) {
				player1 = 0;
				System.out.println("抱歉，你被踩回原点了");
			}
			break;
		case 1:// 幸运轮盘
			System.out.println("\n◆◇◆◇◆欢迎进入幸运轮盘◆◇◆◇◆");
			System.out.println("   请选择一种运气：");
			System.out.println("   1. 交换位置  2. 轰炸");
			System.out.println("=============================\n");
			int chioce = scanner.nextInt();
			switch (chioce) {
			case 1:
				if (note == 1) {
					int temp = position;
					position = player2;
					player2 = temp;
				} else if (note == 2) {
					int temp = position;
					position = player1;
					player1 = temp;
				}
				break;
			case 2:
				if (note == 1 && player2 < 6) {
					player2 = 0;
				} else {
					player2 -= 6;
				}
				if (note == 2 && player1 < 6) {
					player1 = 0;
				} else {
					player1 -= 6;
				}
				break;
			default:
				break;
			}
			break;
		case 2: // 时空隧道
			position = position + 10; // 进入时空隧道，加走10步
			System.out.println("|-P  " + "进入时空隧道， 真爽！");
			break;
		case 3: // 踩到地雷
			position = position - 6; // 踩到地雷退6步
			System.out.println("啦啦啦.....恭喜你踩到地雷...");
			break;
		case 4: // 下一次暂停一次
			goAndstop[note - 1] = "off"; // 设置下次暂停掷骰子
			System.out.println("~~>_<~~  要停战一局了。");
			break;
		}
		// 返回此次掷骰子后玩家的位置坐标
		if (position < 0) {
			return 0;
		} else if (position > 99) {
			return 99;
		} else {
			return position;
		}

	}

	public static int throwDice(int note) {
		int step = 0;
		System.out
				.print("\n\n" + playerName[note - 1] + ", 请您按任意字母键后回车启动掷骰子： ");
		Scanner scanner = new Scanner(System.in);
		String aws = scanner.next();// 随便输入一个数字进行置骰子
		step = (int) (Math.random() * 10) % 6 + 1;// 从1~6随机出数字
		return step;
	}
	
	public static void judgement(){
		if(player1>player2 &&player1>99)
		{
	        System.out.println("\n\n\n\n");
	        System.out.print("****************************************************\n");
	    	System.out.print("                      Game  Over                    \n");
	    	System.out.print("****************************************************\n\n");
			System.out.println("\n恭喜" + playerName[0] + "将军! 您获胜了！");
			
		}
		
		if(player1<player2 &&player2>99){
	        System.out.println("\n\n\n\n");
	        System.out.print("****************************************************\n");
	    	System.out.print("                      Game  Over                    \n");
	    	System.out.print("****************************************************\n\n");
			System.out.println("\n恭喜" + playerName[1] + "将军! 您获胜了！");
		}
	}
	// 设置游戏
	// **********************************************************************************
	public static void main(String[] args) {
		// 测试地图
		KnightChess k = new KnightChess();
		k.createMap();
		//k.showMap(31, 32);
//		showRLine(31, 35, 31, 32);
		//
		// *************************************************************************************、
		// 初始化游戏
		setGame();
		createMap();
		System.out.println("※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※");
		System.out
				.println("//                                                //");
		System.out
				.println("//                                                //");
		System.out
				.println("//             骑    士    飞    行    棋               //");
		System.out
				.println("//                                                //");
		System.out
				.println("//                                                //");
		System.out.println("※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※\n\n\n");
		System.out
				.println("\n~~~~~~~~~~~~~~~~~~~两  人  对  战~~~~~~~~~~~~~~~~~~~");
		System.out.println("\n请选择角色: 1. 戴高乐 2. 艾森豪威尔 3. 麦克阿瑟 4. 巴顿");
		System.out.print("请玩家1选择角色： ");
		Scanner input = new Scanner(System.in);
		int role1 = input.nextInt();
		int role2 = 0;
		do {
			System.out.print("请玩家2选择角色： ");
			role2 = input.nextInt(); // 双方选择角色代号
		} while (role1 == role2); // 不允许角色重复
		setRole(1, role1);
		setRole(2, role2);
		// 初始化游戏
		// *************************************************************************************

		// *************************************************************************************
		// 开始游戏
		System.out.println("\n\n\n\n");
		System.out.print("\n\n****************************************************\n");
		System.out.print("                     Game  Start                    \n");
		System.out.print("****************************************************\n\n");

		// 显示对战双方士兵样式
		System.out.println("^_^" + playerName[0] + "的士兵：　Ａ");
		System.out.println("^_^" + playerName[1] + "的士兵：  Ｂ\n");
		
		// 显示对战地图
		System.out.println("\n图例： " + "■ 暂停  ¤ 幸运轮盘   ★ 地雷   〓 时空隧道   ∷ 普通\n");
		showMap(player1, player2); // 显示当前地图
		int step=0;
		while (player1 < 99 && player2 < 99) {

			// 轮流置骰子
			if (goAndstop[0] == "on") {
				step = throwDice(1);// 置骰子
				System.out.println("\n-----------------"); // 显示结果信息
				System.out.println("骰子数： " + step);
				player1 = gameRules(1, player1, step); // 计算这一次移动后的当前位置
				System.out.println("\n您当前位置：  " + player1);
				System.out.println("对方当前位置：" + player2);
				System.out.println("-----------------\n");
				showMap(player1, player2); // 显示当前地图
				if (player1 == 99) { // 如果走到终点
					break; // 退出
				}
			}else{
	  			  System.out.println("\n" + playerName[0] +"停掷一次！\n");   //显示此次暂停信息
	  			  goAndstop[0] = "on";   //设置下次可掷状态 
	  		  }
			if (goAndstop[1] == "on") {
				step = throwDice(2);// 置骰子
				System.out.println("\n-----------------"); // 显示结果信息
				System.out.println("骰子数： " + step);
				player2 = gameRules(1, player2, step); // 计算这一次移动后的当前位置
				System.out.println("\n您当前位置：  " + player1);
				System.out.println("对方当前位置：" + player2);
				System.out.println("-----------------\n");
				showMap(player1, player2); // 显示当前地图
				if (player2 == 99) { // 如果走到终点
					break; 
				}
			}else{
  			  System.out.println("\n" + playerName[1] +"停掷一次！\n");   //显示此次暂停信息
  			  goAndstop[1] = "on";   //设置下次可掷状态 
  		  }

			// 开始游戏
			// *************************************************************************************
	          //游戏结束

	    	 judgement();
		}
	}
}

