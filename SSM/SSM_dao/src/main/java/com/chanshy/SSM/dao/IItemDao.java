package com.chanshy.SSM.dao;

import com.chanshy.SSM.domain.Item;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;


public interface IItemDao {

    // 查询所有商品
    @Select("select * from item")
    public List<Item> findAll() throws Exception;

    @Insert("insert into item(itemName,itemPrice, itemSales, itemComment, itemDetail)" +
            "values(#{itemName}, #{itemPrice}, #{itemSales}, #{itemComment}, #{itemDetail})")
    void save(Item item);

    @Select("select * from item where id = #{id}")
    public Item findItem(int id) throws Exception;

    @Update("update item set itemName=#{itemName}, itemPrice=#{itemPrice},itemSales=#{itemSales}," +
            "itemComment=#{itemComment}, itemDetail=#{itemDetail} where id=#{id}")
    void alter(Item item);

    @Update("delete from item where id=#{id}")
    void deleteItem(Integer id);
}
