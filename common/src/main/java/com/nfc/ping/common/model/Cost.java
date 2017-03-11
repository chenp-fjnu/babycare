package com.nfc.ping.common.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
/**
 * Created by chenp_fjnu on 2017/3/11.
 */
@DatabaseTable(tableName = "tb_cost")
public class Cost implements IModel {
    @DatabaseField(generatedId = true)
    public int id;
    @DatabaseField
    public String costTitle;
    @DatabaseField
    public String costDate;
    @DatabaseField
    public String costMoney;
    public Cost()
    {
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getCostTitle()
    {
        return costTitle;
    }

    public void setCostTitle(String costTitle)
    {
        this.costTitle = costTitle;
    }
    public String getCostDate()
    {
        return costTitle;
    }

    public void setCostDate(String costDate)
    {
        this.costDate = costDate;
    }
    public String getCostMoney()
    {
        return costMoney;
    }

    public void setCostMoney(String costMoney)
    {
        this.costMoney = costMoney;
    }
    @Override
    public String toString()
    {
        return "Cost [id=" + id + ", title=" + costTitle + ", date=" + costDate+ ", money=" + costMoney
                + "]";
    }
}
