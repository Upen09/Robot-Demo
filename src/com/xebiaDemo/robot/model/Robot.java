package com.xebiaDemo.robot.model;

public class Robot {

	private Integer chargingLevel;
	private String lightColor;

	public Robot(Builder builder) {
		this.setChargingLevel(builder.chargingLevel);
		this.setLightColor(builder.lightColor);
	}

	/**
	 * @return the chargingLevel
	 */
	public Integer getChargingLevel() {
		return chargingLevel;
	}

	/**
	 * @param chargingLevel the chargingLevel to set
	 */
	public void setChargingLevel(Integer chargingLevel) {
		this.chargingLevel = chargingLevel;
	}

	/**
	 * @return the lightColor
	 */
	public String getLightColor() {
		return lightColor;
	}

	/**
	 * @param lightColor the lightColor to set
	 */
	public void setLightColor(String lightColor) {
		this.lightColor = lightColor;
	}

	

	public static class Builder {

		private Integer chargingLevel;
		private String lightColor;

		public static Builder newInstance() {
			return new Builder();
		}

		private Builder() {
		}

		// Setter methods
		public Builder setChargingLevel(int chargingLevel) {
			this.chargingLevel = chargingLevel;
			return this;
		}

		public Builder setLightColor(String lightColor) {
			this.lightColor = lightColor;
			return this;
		}

		// build method to deal with outer class
		// to return outer instance
		public Robot build() {
			return new Robot(this);
		}

	}
}
