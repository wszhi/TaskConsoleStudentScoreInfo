## 学生成绩单

背景:

https://www.zybuluo.com/jtong/note/471501  中的课后作业

打印所有人的成绩单,包括平均分和总分。

打印全班级的总分平均分和中位数。

## 列Task 

1) 转换ViewModel

输入:

    studentScoresArray:[[String]]
    
输出:

    studentScoresSheet:[{
        name:String,
        chinese:double,
        english:double,
        math:double,
        programming:double
        },
        {
        ...
        }]
        
2) 得到学生成绩

输入:

    studentScoresSheet
    
输出:

    studentScoresSheetWithSummary:[{
        name:String,
        chinese:double,
        english:double,
        math:double,
        programming:double,
        average:double,
        total:double
        },
        {
         ...
        }]
        
3) 计算总计

输入:

    studentScoresSheetWithSummary
    
输出:

    summary:{
        totalAverage:double,
        totalMidden:double
        }
        
4) 打印成绩单

输入:

    studentScoresSheetWithSummary
    summary
    
输出:

    Result:String