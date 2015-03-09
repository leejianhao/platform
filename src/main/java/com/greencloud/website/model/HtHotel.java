package com.greencloud.website.model;

import java.io.Serializable;
import java.util.List;

import org.aspectj.apache.bcel.classfile.Code;

import com.greencloud.website.dto.Room;


public class HtHotel implements Serializable{
    private Long id;

    private String code;

    private String descript;

    private Integer roomNum;

    private String phone;

    private String fax;

    private String address;

    private String provinceCode;

    private String cityCode;

    private String cityDescript;

    private String districtCode;

    private String townCode;

    private String shoppingDistrictCode;

    private String scenicSpotCode;

    private Integer listOrder;

    private String categoryCode;

    private String categoryDescript;

    private Integer bookListOrder;

    private String extraFlag;

    private String brandCode;

    private String mainImg;

    private String smallRmImg;

    private String bigRmImg;

    private String remarket;

    private String mapImage;

    private String startLevel;

    private Float score;

    private String shortDescript;

    private String brandImg;

    private String mapHtml;

    private String ttpComment;
    
    private String minRate;
    
    private String preview;
    
    private String coordinates;
    
    private String isDirect;
    
    private List<Room> roomList;
	
	private List<Code> rateCodes;
	
	private List<Code> rmtypes;
	
	private String logo;

    private String rooms;
	
	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public Integer getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(Integer roomNum) {
        this.roomNum = roomNum;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityDescript() {
        return cityDescript;
    }

    public void setCityDescript(String cityDescript) {
        this.cityDescript = cityDescript;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public String getTownCode() {
        return townCode;
    }

    public void setTownCode(String townCode) {
        this.townCode = townCode;
    }

    public String getShoppingDistrictCode() {
        return shoppingDistrictCode;
    }

    public void setShoppingDistrictCode(String shoppingDistrictCode) {
        this.shoppingDistrictCode = shoppingDistrictCode;
    }

    public String getScenicSpotCode() {
        return scenicSpotCode;
    }

    public void setScenicSpotCode(String scenicSpotCode) {
        this.scenicSpotCode = scenicSpotCode;
    }

    public Integer getListOrder() {
        return listOrder;
    }

    public void setListOrder(Integer listOrder) {
        this.listOrder = listOrder;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getCategoryDescript() {
        return categoryDescript;
    }

    public void setCategoryDescript(String categoryDescript) {
        this.categoryDescript = categoryDescript;
    }

    public Integer getBookListOrder() {
        return bookListOrder;
    }

    public void setBookListOrder(Integer bookListOrder) {
        this.bookListOrder = bookListOrder;
    }

    public String getExtraFlag() {
        return extraFlag;
    }

    public void setExtraFlag(String extraFlag) {
        this.extraFlag = extraFlag;
    }

    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    public String getMainImg() {
        return mainImg;
    }

    public void setMainImg(String mainImg) {
        this.mainImg = mainImg;
    }

    public String getSmallRmImg() {
        return smallRmImg;
    }

    public void setSmallRmImg(String smallRmImg) {
        this.smallRmImg = smallRmImg;
    }

    public String getBigRmImg() {
        return bigRmImg;
    }

    public void setBigRmImg(String bigRmImg) {
        this.bigRmImg = bigRmImg;
    }

    public String getRemarket() {
        return remarket;
    }

    public void setRemarket(String remarket) {
        this.remarket = remarket;
    }

    public String getMapImage() {
        return mapImage;
    }

    public void setMapImage(String mapImage) {
        this.mapImage = mapImage;
    }

    public String getStartLevel() {
        return startLevel;
    }

    public void setStartLevel(String startLevel) {
        this.startLevel = startLevel;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public String getShortDescript() {
        return shortDescript;
    }

    public void setShortDescript(String shortDescript) {
        this.shortDescript = shortDescript;
    }

    public String getBrandImg() {
        return brandImg;
    }

    public void setBrandImg(String brandImg) {
        this.brandImg = brandImg;
    }

    public String getMapHtml() {
        return mapHtml;
    }

    public void setMapHtml(String mapHtml) {
        this.mapHtml = mapHtml;
    }

    public String getTtpComment() {
        return ttpComment;
    }

    public void setTtpComment(String ttpComment) {
        this.ttpComment = ttpComment;
    }
    
    public List<Code> getRateCodes() {
		return rateCodes;
	}
	public void setRateCodes(List<Code> rateCodes) {
		this.rateCodes = rateCodes;
	}
	
	public List<Code> getRmtypes() {
		return rmtypes;
	}
	public void setRmtypes(List<Code> rmtypes) {
		this.rmtypes = rmtypes;
	}
	
	
	public List<Room> getRoomList() {
		return roomList;
	}

	public void setRoomList(List<Room> roomList) {
		this.roomList = roomList;
	}

	
	public String getMinRate() {
		return minRate;
	}
	
	public void setMinRate(String minRate) {
		this.minRate = minRate;
	}

	public String getPreview() {
		return preview;
	}

	public void setPreview(String preview) {
		this.preview = preview;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}

	public String getCoordinates() {
		return coordinates;
	}

	public String getIsDirect() {
		return isDirect;
	}

	public void setIsDirect(String isDirect) {
		this.isDirect = isDirect;
	}

	public String getRooms() {
		return rooms;
	}

	public void setRooms(String rooms) {
		this.rooms = rooms;
	}
	
}