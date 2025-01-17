

[Test Plan](#test-plan)

[Assumptions](#assumptions)

[Objective](#objective)

[Test Scope](#test-scope)

[Test Strategy](#test-strategy)

[Test Levels](#test-levels)

[Test Types](#test-types)

[Test Approaches and Techniques](#test-approaches-and-techniques)

[Environments](#environments)

[Entry And Exit Criteria](#entry-and-exit-criteria)

[Feature Testing (Applied for each Feature separately):](#feature-testing-\(applied-for-each-feature-separately\):)

[Entry Criteria:](#entry-criteria:)

[Exit Criteria:](#exit-criteria:)

[System Testing:](#system-testing:)

[Entry Criteria:](#entry-criteria:-1)

[Exit Criteria:](#exit-criteria:-1)

[System Integration Testing:](#system-integration-testing:)

[Entry Criteria:](#entry-criteria:-2)

[Exit Criteria:](#exit-criteria:-2)

[User Acceptance Testing:](#user-acceptance-testing:)

[Entry Criteria:](#entry-criteria:-3)

[Exit Criteria:](#exit-criteria:-3)

[Stage Testing:](#stage-testing:)

[Entry Criteria:](#entry-criteria:-4)

[Exit Criteria:](#exit-criteria:-4)

[Resource Planning](#resource-planning)

[Test Schedule](#test-schedule)

[Scope of Testing](#scope-of-testing)

# Test Plan {#test-plan}

## Assumptions {#assumptions}

* Next Release will include all Stories from Scope
* This is the first release
* Suppose we release iOS application
* Because of the absence of Stakeholders all decisions are made based on experience of the Test Manager. Constraints such as resources, environments, and schedules may be discussed and adjusted accordingly.

## Objective {#objective}

The primary objective of this test plan is to ensure comprehensive validation of the investment platform's core functionalities, focusing on user authentication, account upgrades, loan processing, corporate verification and integration with \[X\] System features.

## Test Scope {#test-scope}

Testing scope of this release consists of User Stories mentioned in the **Scope of Testing** section.

## Test Strategy {#test-strategy}

The test approach for the current release is based on a Risk-Based Testing approach. All test activities aim to minimize risks by prioritizing the most critical areas.  
The registered risks, analysis, related test cases, and priority of test case execution in the feature testing and system integration testing cycles can be found in the **Soar-Tests** file.

### Test Levels {#test-levels}

1. Unit Testing. Will be performed by the development team.
2. Feature Testing (Functional Testing of each User Story) on the QA environment. The goal of this Test Type is to ensure each feature meets Acceptance Criteria.
3. System Testing and System Integration Testing on SIT environment. The goals:
    1. Ensure all features work together
    2. Ensure integration with third-party systems works as expected

   There may be more than one cycle of System Integration Testing Cycle, if the number of defects and fixed defects significantly impacts the application’s functionality and User Experience.

4. User Acceptance Testing. On UAT environment. The goal:
    1. Ensure the planned functionality satisfies stakeholders expectations.
5. Stage Testing
6. Post-Release Testing

### Test Types {#test-types}

1. Regression Testing. Since this is a first release and there is no yet old codebase this type of testing  will be omitted.
2. User Acceptance Testing. Will be performed by stakeholders as End-Users and Users of Third-Party systems
3. Security Testing. Security is a crucial aspect of non-functional requirements for an investment-related application. It will be performed by a dedicated Team on QA, SIT, UAT environments.
4. Deployment-Rollback Testing.

### Test Approaches and Techniques {#test-approaches-and-techniques}

1. Risk-Based Approach. To optimize resources and minimize risks, a Risk-Based approach will be utilized.
2. Edge Case Testing approach (Boundary Values approach)

## Environments {#environments}

The following environments are required to perform test activities. The QA, SIT, UAT, and STAGE environments should contain test data from production (data should be obfuscated and not contain sensitive information such as passwords).

1. DEV environment: Controlled by development team
2. QA environment: Controlled by test team. Here, the test team conducts feature testing. Third-Party services are stubbed with mocks.
3. SIT environment: Controlled by test team. Here,  the test team performs system integration testing and regression testing. Environment should be connected to corresponding environments of Third-Party Systems
4. UAT environment: controlled by product management team. Here, the  product management team conducts user acceptance testing, demo for stakeholders. Environment should be connected to corresponding environments of Third-Party Systems.
5. STAGE environment: A replica of PROD env to perform production scenarios like deploy, rollback.

There might be additional specific Environments for specific Goals:

1. Automation Environment. To perform Automation testing. Controlled by the automation test team.
2. Performance Environment. To perform Performance testing. Controlled by the performance test team.

## Entry And Exit Criteria {#entry-and-exit-criteria}

### Feature Testing (Applied for each Feature separately): {#feature-testing-(applied-for-each-feature-separately):}

#### Entry Criteria: {#entry-criteria:}

1. Unit Tests are passed
2. Deployment Scripts are updated by responsible Dev Engineers
3. QA environment is operational and contains required Test Data
4. Feature Deployed to QA environment

#### Exit Criteria: {#exit-criteria:}

1. All defects are fixed, deployed and verified by QA representative
2. Test Cases are created, documented in TCMS and verified

### System Testing:  {#system-testing:}

#### Entry Criteria: {#entry-criteria:-1}

1. SIT environment is operational and contains required Test Data
2. All Features defined as Release Scope are deployed to SIT environment
3. Test Suite is ready to run

#### Exit Criteria: {#exit-criteria:-1}

1. All planned Tests are performed
2. All found defects are registered in Defect Management System
3. All Defects are resolved (e.g. fixed, deferred, cancelled)

### System Integration Testing: {#system-integration-testing:}

#### Entry Criteria: {#entry-criteria:-2}

1. List of Third-party Services is defined
2. All third-party Services are connected and version control is fixed
3. Third-party Services up and running
4. Thirt-party Stakeholders are defined
5. System Testing is in progress
6. Test Suite related to SIT is defined

#### Exit Criteria: {#exit-criteria:-2}

1. All SIT Test Cases performed
2. All Defects are resolved (e.g. fixed, deferred, cancelled)
3. Third-Party Stakeholders sign offs obtained

### User Acceptance Testing: {#user-acceptance-testing:}

#### Entry Criteria: {#entry-criteria:-3}

1. Feature Testing Level completed
2. UAT environment is operational and contains all required Test Data
3. UAT environment is updated with planned features

#### Exit Criteria: {#exit-criteria:-3}

1. All planned Features are signed off with Stakeholders/Product Management Team

### Stage Testing: {#stage-testing:}

#### Entry Criteria: {#entry-criteria:-4}

1. Deployment Procedures and Scripts are ready
2. Post-Deployment Test Suite is ready
3. STAGE env identical to Prod is ready

#### Exit Criteria: {#exit-criteria:-4}

1. Deployment performed with errors
2. Tests performed and no bugs found

## Resource Planning {#resource-planning}

All QA activities will be performed by one QA engineer.

## Test Schedule {#test-schedule}

Assuming all resources are available:

1. QA Engineer is available.
    2. Dev Team available and responsive.
    3. Product Team representative is available and responsive.
    4. Required environments are available and operational.
    5. The \[X\] integration is available during SIT cycles.

Any lack of those items can lead to Schedule prolongation

Test Schedule below incorporates Buffers to mitigate Risks related to issues mentioned above.

| Cycle | Planned Start Date | Planned End Date |
| :---- | :---- | :---- |
| Feature Testing | February 3, 2025 | February 7, 2025 |
| System Integration Testing Cycle 1 | February 13, 2025 | February 19, 2025 |
| System Integration Testing Cycle 2 (if needed) | February 24, 2025 | February 28, 2025 |

# Scope of Testing {#scope-of-testing}

**User Story 1: Registered User Login From a New Device**  
**Description:**  
As a registered user, I want to log in from a new device and log out from all other devices so that I can ensure my account’s security and access it from anywhere.  
**Acceptance Criteria: Successful Login.**

**Given** that my account is already created in the system.  
**When** I am on the login page.  
**And** I click on the “Login” button.  
**Then** I should be able to enter my phone number and password.  
**And** I should be able to click on the “Next” button.  
**And** the system should validate my inputs.  
**And** I should be redirected to enter the OTP.  
**And** I should be able to click on the “Login” button and log in successfully.  
**And** the system should notify me with a successful login message.  
**And** the system should send SMS notification to the user after the successful login from new device.   
**And** the user account should be Logged out from all other logged-in devices.   
**And** I should be redirected to the home page.

**User Story 2: Individual Investor \- Upgrade to Premium**  
**Description:**  
As a verified individual user, I want to upgrade my regular account to a premium account so that I can be able to get all the premium account features.  
**Acceptance Criteria:**  
**Given** that I am a verified individual investor user.   
**And** I want to upgrade to a premium account.  
**When** I click on the “Upgrade to Premium” button.  
**Then** I should be able to choose at least one of the following options:

* Do you have assets worth amount 3 million SAR?
* Do you work or has been worked before in the financial sector position related to investment or finance for at least 3 years?
* Do you have a certificate in finance or investment sector from an accredited internationally recognized organization?

  **When** I selected one option from the previous page.

  **Then** I should be able to upload **documents,** and prove ownership of these documents.

  **And** the compliance department staff members should be able to view and approve the upgrade request.

  **And** the relation manager responsible for this user account should be notified by the compliance team about the request status.

  **And** I should get a notification once the documents are uploaded successfully.


**User Story 3: Approvals Notifications | SMS**

**Description:**

As a loan requester, I want to receive timely notifications about my loan request status so that I can stay informed during the approval process.

**Acceptance Criteria:**

**Scenario 1: Approval Notification**

**Given** all relevant departments and the relationship manager have approved a loan request.

**When** the system processes the final approval.

**Then** the loan requester should receive an SMS indicating the approval status.

**Scenario 2: Rejection Notification with Reasons**

**Given** that loan request has been rejected at any stage of approvals with specified reasons.

**When** the system processes the rejection at any step during departments approvals stage.

**Then** the relation manager responsible for the request should be notified to communicate the reasons with the loan requester and solve the issues.

**When** the relation manager rejects the loan request. (Final Rejection) **Then** the loan requester should receive an SMS indicating the rejection with the specified reasons provided by the relation manager only.


**User Story 4: Departments Approval**

**Description:**

As a department staff member, I want to review and approve loan requests from my department, so that I can contribute to the overall approval process.

**Acceptance Criteria:**

**Scenario 1: Approving a Request in Review**

**Given** that a loan request is currently in review by a specific department.

**When** the department representative reviews the request.

**Then** they should see an "Approve" button.

**When** the representative clicks "Approve".

**Then** the request should be marked as approved from their department.


**Scenario 2: Viewing Department Approvals**

**Given** that a loan request has been approved by multiple departments.

**When** the system user views the details of the request.

**Then** they should see a section displaying all departments that have approved the request, with the staff members who gave the approval and the timestamp of each approval.


**User Story 5: Corporate Investor \- Commercial Registration Verification Via \[X\]**

**Description:**

As a system, I want to confirm the commercial registration of corporate investors using the third-party service \[X\] so that I can retrieve necessary information about corporate clients who want to invest in our system.

**Acceptance Criteria:**

**Scenario 1: Integration with \[X\]**

**Given** the system is integrated with \[X\]

**And** I have finished my commercial registration successfully.

**Then** the system should send my commercial registration number to \[X\].

**Scenario 2: Valid Data**

**Given** that I want to verify corporate investor commercial registration number.

**When** the system gets result from third party (X) that my commercial registration number inputs is valid.

**Then** I should be able to proceed now to the validation process.

**Scenario 3: Invalid Data**

**Given** that i have entered an invalid commercial registration number.

**When** the system gets result from third party (X) that my commercial registration number is invalid.

**Then** the system should ask me to enter the valid number for commercial registration.

**And** after filling the new commercial registration number, the system should restart the verification process with third party (X) with the new number.

**Scenario 4: Validation for the Start Date is Negative**

**Given** that the verification process via third party (X) is successfully done.

**When** the system got the result from third party (X).

**Then** the system should validate the output number:15 (**company start date**). **And**:

* If it is less than two years, system will notify the user that he will not be able to proceed.
* If it is more than two years, system will proceed with the user to next step. 