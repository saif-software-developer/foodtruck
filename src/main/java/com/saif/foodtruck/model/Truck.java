package com.saif.foodtruck.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Truck {

    @JsonProperty("dayorder")
    private String dayOrder;
    @JsonProperty("dayofweekstr")
    private String dayOfWeekStr;
    @JsonProperty("starttime")
    private String startTime;
    @JsonProperty("endtime")
    private String endTime;
    @JsonProperty("permit")
    private String permit;
    private String location;
    @JsonProperty("locationdesc")
    private String locationDesc;
    @JsonProperty("optionaltext")
    private String optionalText;
    @JsonProperty("locationid")
    private String locationId;
    private String start24;
    private String end24;
    private String cnn;
    @JsonProperty("addr_date_create")
    private String addrDateCreate;
    @JsonProperty("addr_date_modified")
    private String addrDateModified;
    private String block;
    private String lot;
    @JsonProperty("coldtruck")
    private String coldTruck;
    private String applicant;
    private String x;
    private String y;
    private String latitude;
    private String longitude;
    @JsonProperty("location_2")
    private Location location2;

    public String getDayOrder() {
        return dayOrder;
    }

    public void setDayOrder(String dayOrder) {
        this.dayOrder = dayOrder;
    }

    public String getDayOfWeekStr() {
        return dayOfWeekStr;
    }

    public void setDayOfWeekStr(String dayOfWeekStr) {
        this.dayOfWeekStr = dayOfWeekStr;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getPermit() {
        return permit;
    }

    public void setPermit(String permit) {
        this.permit = permit;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocationDesc() {
        return locationDesc;
    }

    public void setLocationDesc(String locationDesc) {
        this.locationDesc = locationDesc;
    }

    public String getOptionalText() {
        return optionalText;
    }

    public void setOptionalText(String optionalText) {
        this.optionalText = optionalText;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getStart24() {
        return start24;
    }

    public void setStart24(String start24) {
        this.start24 = start24;
    }

    public String getEnd24() {
        return end24;
    }

    public void setEnd24(String end24) {
        this.end24 = end24;
    }

    public String getCnn() {
        return cnn;
    }

    public void setCnn(String cnn) {
        this.cnn = cnn;
    }

    public String getAddrDateCreate() {
        return addrDateCreate;
    }

    public void setAddrDateCreate(String addrDateCreate) {
        this.addrDateCreate = addrDateCreate;
    }

    public String getAddrDateModified() {
        return addrDateModified;
    }

    public void setAddrDateModified(String addrDateModified) {
        this.addrDateModified = addrDateModified;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getLot() {
        return lot;
    }

    public void setLot(String lot) {
        this.lot = lot;
    }

    public String getColdTruck() {
        return coldTruck;
    }

    public void setColdTruck(String coldTruck) {
        this.coldTruck = coldTruck;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Location getLocation2() {
        return location2;
    }

    public void setLocation2(Location location2) {
        this.location2 = location2;
    }

    public String getProcessedLatitude() {
        try {
            if (location2 != null && location2.getCoordinates() != null && location2.getCoordinates().size() > 1) {
                Object latObj = location2.getCoordinates().get(1);
                if (latObj != null) {
                    return String.valueOf(latObj);
                }
            }
        } catch (IndexOutOfBoundsException | ClassCastException e) {
            // Log error or handle appropriately
        }
        return getLatitude(); // Fallback to existing latitude field
    }

    public String getProcessedLongitude() {
        try {
            if (location2 != null && location2.getCoordinates() != null && !location2.getCoordinates().isEmpty()) {
                Object longObj = location2.getCoordinates().get(0);
                if (longObj != null) {
                    return String.valueOf(longObj);
                }
            }
        } catch (IndexOutOfBoundsException | ClassCastException e) {
            // Log error or handle appropriately
        }
        return getLongitude(); // Fallback to existing longitude field
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Truck truck = (Truck) o;
        return Objects.equals(dayOrder, truck.dayOrder) &&
                Objects.equals(dayOfWeekStr, truck.dayOfWeekStr) &&
                Objects.equals(startTime, truck.startTime) &&
                Objects.equals(endTime, truck.endTime) &&
                Objects.equals(permit, truck.permit) &&
                Objects.equals(location, truck.location) &&
                Objects.equals(locationDesc, truck.locationDesc) &&
                Objects.equals(optionalText, truck.optionalText) &&
                Objects.equals(locationId, truck.locationId) &&
                Objects.equals(start24, truck.start24) &&
                Objects.equals(end24, truck.end24) &&
                Objects.equals(cnn, truck.cnn) &&
                Objects.equals(addrDateCreate, truck.addrDateCreate) &&
                Objects.equals(addrDateModified, truck.addrDateModified) &&
                Objects.equals(block, truck.block) &&
                Objects.equals(lot, truck.lot) &&
                Objects.equals(coldTruck, truck.coldTruck) &&
                Objects.equals(applicant, truck.applicant) &&
                Objects.equals(x, truck.x) &&
                Objects.equals(y, truck.y) &&
                Objects.equals(latitude, truck.latitude) &&
                Objects.equals(longitude, truck.longitude) &&
                Objects.equals(location2, truck.location2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dayOrder, dayOfWeekStr, startTime, endTime, permit, location, locationDesc, optionalText, locationId, start24, end24, cnn, addrDateCreate, addrDateModified, block, lot, coldTruck, applicant, x, y, latitude, longitude, location2);
    }

    @Override
    public String toString() {
        return "Truck{" +
                "dayOrder='" + dayOrder + '\'' +
                ", dayOfWeekStr='" + dayOfWeekStr + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", permit='" + permit + '\'' +
                ", location='" + location + '\'' +
                ", locationDesc='" + locationDesc + '\'' +
                ", optionalText='" + optionalText + '\'' +
                ", locationId='" + locationId + '\'' +
                ", start24='" + start24 + '\'' +
                ", end24='" + end24 + '\'' +
                ", cnn='" + cnn + '\'' +
                ", addrDateCreate='" + addrDateCreate + '\'' +
                ", addrDateModified='" + addrDateModified + '\'' +
                ", block='" + block + '\'' +
                ", lot='" + lot + '\'' +
                ", coldTruck='" + coldTruck + '\'' +
                ", applicant='" + applicant + '\'' +
                ", x='" + x + '\'' +
                ", y='" + y + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", location2=" + location2 +
                '}';
    }
}

