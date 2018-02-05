package com.java4s;

public class CTP_Input {
	String requirementId;
	String testPlanName;
	public String getRequirementId() {
		return requirementId;
	}
	public void setRequirementId(String requirementId) {
		this.requirementId = requirementId;
	}
	public String getTestPlanName() {
		return testPlanName;
	}
	public void setTestPlanName(String testPlanName) {
		this.testPlanName = testPlanName;
	}
	@Override
	public String toString() {
		return "CTP_Input [requirementId=" + requirementId + ", testPlanName=" + testPlanName + "]";
	}
	
}
