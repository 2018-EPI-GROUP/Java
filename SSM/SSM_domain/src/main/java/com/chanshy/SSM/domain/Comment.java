package com.chanshy.SSM.domain;

import net.sf.jsqlparser.expression.DateTimeLiteralExpression.DateTime;

public class Comment {
    private int id; // 主键
    private String commentBody; // 评论正文
    private String userName; // 评论者
    private DateTime publishedTime; // 评论时间
}
