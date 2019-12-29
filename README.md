# Project_2
19302010020 袁逸聪

# 构架设计
工程文件由两个包构成：GameData和GUI
另有与src同级的文件夹map存放存档文件，audio存放音频，pic存放图片，resources/fonts存放字体

## GameData包
分为Lattice、Map、MotaGame三个类，其他类都是Lattice的子类
GameData中构建了游戏逻辑，可以存取完整的游戏数据、设计了游戏内容相关的对象

### Map类
用于地图存取，将程序和map文件夹中的txt存档文件构建联系
参数中设置save用于读档存档、redo用于悔棋和撤销
一个数字表示轮次，作为参数传入，读档存档时用0,
第二个数字是存档文件的编号，每轮存档都是从0到4，分别是储存5个楼层的信息（附带勇者信息）

### Lattice类
用于表示地图中每一格对象的类，存放在Lattice包中
Lattice包中直接存放Player表示勇者，以及仅改变勇者位置没有过多功能的地图块如楼梯、空地
Lattice包下属4个子包
Item包存放可拾取的物品类，触发事件或改变勇者属性
Monster包存放怪物类，可以与勇者战斗
	因此需要额外实现fightWith函数
Npc包存放有额外功能的人物，如老人和商人，可以与勇者对话，产生弹框进一步选择
	因此需要存放更多数据，给弹框提供信息
Roadblock包存放会阻碍勇者移动的物块
	因此大部分时候需要调用勇者的moveCancle函数，取消移动

Lattice需要继承的函数：
	affectWith用于在勇者即将走上来的时候与勇者发生交互
	getCode返回这一对象在txt存档中对应的代码
	getGraphic返回对象相应图片的地址
	getAudio返回对象所发声音的地址（如果有）

以上函数需要被将被实例化存入游戏状态的对象继承，而它们的一些父类、Lattice的一些子类不需要
比如蝙蝠BatSmall和大蝙蝠BatLarge的父类Bat就无须继承getCode,getGraphic,getAudio
而需要重写fightWith函数供子类继承
而Bat的父类Monster还需要实现fightEnd函数，用于给所有Monster的子类在战斗结束时运行

### MotaGame类
这是综合完整数据的类，具有私有变量map（Lattice的三维数组）和player
除了get类方法外，唯一的方法是move，以Game（GUI包中的类）和int[]为参数
实现游戏数据和GUI界面的信息流通
运作流程:
1 在通过传入的数组改变勇者位置，同时保存旧位置
2 如果勇者原本的位置不是楼梯，就变成空地
3 使新位置的对象与勇者交互，根据对象的不同，可能阻止勇者移动（恢复成旧位置）、进行自动存档（如果这一步有具体意义的话，如果是撞墙就不会执行，自动存档用于撤销和取消撤销）
  以上识别内化于affectWith函数的多态性，无须由move函数判断
4 调用Game类实体对象game的public函数，完成UI界面更新

## GUI包

