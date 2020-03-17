package s1java.xmal1;

public class Map {
	int[] map = new int[100];   //对战地图
	int[] luckyTurn = {6, 23, 40, 55, 69, 83}; //幸运轮盘 
	int[] landMine = {5, 13, 17, 33, 38, 50, 64, 80, 94};   //地雷位置
	int[] pause = {9, 27, 60, 93};         //暂停
	int[] timeTunnel = {20, 25, 45, 63, 72, 88, 90};   //时空隧道

 	
	 /**
	   * 生成地图: 
	   * 关卡代号为：1：幸运轮盘 2：地雷  3: 暂停 4：时空隧道 0：普通
	   */
    public void createMap(){
  	    int i = 0; 
  	    
  	    //在对战地图上设置幸运轮盘
  	    for(i = 0; i < luckyTurn.length; i++){
  	    	map[luckyTurn[i]] = 1; 
  	    }
  	    
  	    //在对战地图上设置地雷
  	    for(i = 0; i < landMine.length; i++){
	    	map[landMine[i]] = 2; 
	    }
  	    
  	    //在对战地图上设置暂停
  	    for(i = 0; i < pause.length; i++){
	    	map[pause[i]] = 3; 
	    }
  	    
  	    //在对战地图上设置时空隧道
  	    for(i = 0; i < timeTunnel.length; i++){
	    	map[timeTunnel[i]] = 4; 
	    }
    }
    
    /**
     * 显示地图关卡对应的图形
     * @param i 地图当前位置的关卡代号
     * @param index 当前地图位置编号
     * @param playerPos1 玩家1的当前位置
     * @param playerPos2 玩家2的当前位置
     * @return 地图当前位置的对应图片
     */
    public String getGraph(int i, int index, int playerPos1, int playerPos2){
    	String graph = "";
    	if(index == playerPos1 && index== playerPos2){
    		graph = "@@";
    	}else if(index == playerPos1){	
        	//graph = "♀";
    		graph = "Ａ";
        }else if(index == playerPos2){
        	//graph = "♂";
        	graph = "Ｂ";
        }else{
          switch(i){
    	   case 1:   //幸运轮盘
    		   graph = "¤";
    	       break;
    	   case 2:   //地雷
    		   graph = "★";
    		   break;
    	   case 3:   //暂停
    		   graph = "■";
    		   break;
    	   case 4:   //时光隧道
    		   graph = "〓";
    		   break;
    	   default:
    		   graph = "∷";
    	       break;
    	    }
        }
    	return graph;
    }
    
    /**
     * 输出地图的奇数行（第1、3行）
     * @param start 输出的起始点在地图上的位置
     * @param end  输出的结束点在地图上的位置
     * @param playerPos1 玩家1的当前位置
     * @param playerPos2 玩家2的当前位置
     */
    public void showLine1(int start, int end, int playerPos1, int playerPos2){     
    	for(int i = start; i < end; i++){
    		System.out.print(getGraph(map[i], i, playerPos1, playerPos2));
    	}
    }
    
    /**
     * 输出地图的偶数行（第2行）
     * @param start 输出的起始点在地图上的位置
     * @param end  输出的结束点在地图上的位置
     * @param playerPos1 玩家1的当前位置
     * @param playerPos2 玩家2的当前位置
     */
    public void showLine2(int start, int end, int playerPos1, int playerPos2){    
    	for(int i = end-1; i >= start; i-- ){	
    		System.out.print(getGraph(map[i], i,playerPos1, playerPos2));
    	}
    }
    
    /**
     * 输出地图的右竖列
     * @param start 输出的起始点在地图上的位置
     * @param end  输出的结束点在地图上的位置
     * @param playerPos1 玩家1的当前位置
     * @param playerPos2 玩家2的当前位置
     */
    public void showRLine(int start, int end, int playerPos1, int playerPos2){
    	for(int i = start; i< end; i++){
    	   for(int j = 44; j > 0; j--){  //输出55个空格
    		   System.out.print("  ");
    	   }
    	   System.out.print(getGraph(map[i], i,playerPos1, playerPos2));
    	   System.out.println();
    	}
    }
    
    /**
     * 输出地图的左竖列
     * @param start 输出的起始点在地图上的位置
     * @param end  输出的结束点在地图上的位置
     * @param playerPos1 玩家1的当前位置
     * @param playerPos2 玩家2的当前位置
     */
    public void showLLine(int start, int end, int playerPos1, int playerPos2){
    	for(int i = start; i < end; i++){
    		System.out.println(getGraph(map[i], i,playerPos1, playerPos2));
    	}
    }

    /**
     * 显示对战地图
     * @param playerPos1 玩家1的当前位置
     * @param playerPos2 玩家2的当前位置
     */
    public void showMap(int playerPos1, int playerPos2){
    	showLine1(0, 31, playerPos1, playerPos2);   //显示地图第一行
    	System.out.println();                     //换行
    	showRLine(31,35, playerPos1, playerPos2);  //显示地图右竖行
    	showLine2(35, 66, playerPos1, playerPos2); //显示地图第二行
    	System.out.println();                     //换行
    	showLLine(66, 69, playerPos1, playerPos2); //显示地图左竖行
        showLine2(69, 100, playerPos1, playerPos2); //显示地图第3行
    }  

}

