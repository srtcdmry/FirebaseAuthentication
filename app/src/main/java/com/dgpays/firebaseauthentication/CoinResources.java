package com.dgpays.firebaseauthentication;

import com.google.gson.annotations.SerializedName;

public class CoinResources {
    public String id;
    @SerializedName("coin")
    public String coin;
    @SerializedName("name")
    public String name;
    @SerializedName("type")
    public String type;
    @SerializedName("algorithm")
    public String algorithm;
//    @SerializedName("network_hashrate")
//    public Long network_hashrate;
//    @SerializedName("difficulty")
//    public Long difficulty;
//    @SerializedName("reward")
//    public Long reward;
    @SerializedName("reward_unit")
    public String reward_unit;
//    @SerializedName("reward_block")
//    public Integer reward_block;
    @SerializedName("price")
    public Double price;
    @SerializedName("volume")
    public Double volume;
    @SerializedName("updated")
    public Integer updated;

    public CoinResources(String id, String coin, String name, String type, Double price) {
        this.id = id;
        this.coin = coin;
        this.name = name;
        this.type = type;
        this.price = price;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

//    public Long getNetwork_hashrate() {
//        return network_hashrate;
//    }
//
//    public void setNetwork_hashrate(Long network_hashrate) {
//        this.network_hashrate = network_hashrate;
//    }
//
//    public Long getDifficulty() {
//        return difficulty;
//    }
//
//    public void setDifficulty(Long difficulty) {
//        this.difficulty = difficulty;
//    }
//
//    public Long getReward() {
//        return reward;
//    }
//
//    public void setReward(Long reward) {
//        this.reward = reward;
//    }

    public String getReward_unit() {
        return reward_unit;
    }

    public void setReward_unit(String reward_unit) {
        this.reward_unit = reward_unit;
    }

//    public Integer getReward_block() {
//        return reward_block;
//    }
//
//    public void setReward_block(Integer reward_block) {
//        this.reward_block = reward_block;
//    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Integer getUpdated() {
        return updated;
    }

    public void setUpdated(Integer updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "CoinResources{" +
                "id='" + id + '\'' +
                ", coin='" + coin + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", algorithm='" + algorithm + '\'' +
                ", reward_unit='" + reward_unit + '\'' +
                ", price=" + price +
                ", volume=" + volume +
                ", updated=" + updated +
                '}';
    }
}
