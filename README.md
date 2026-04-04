# Salesforce MuleSoft Account Sync

This project is a MuleSoft-based integration that retrieves Account data from Salesforce, transforms it, and sends it to a mock ERP system. It is built to demonstrate Salesforce connectivity, DataWeave mapping, API orchestration, and end-to-end account sync.

## Overview

The flow is simple:
- Client sends an Account ID to the MuleSoft API
- MuleSoft fetches the Account from Salesforce
- DataWeave maps the Salesforce payload to the ERP format
- MuleSoft sends the transformed payload to the mock ERP API
- A structured success or error response is returned

## Tech Stack

- MuleSoft 4
- Anypoint Studio
- DataWeave 2.0
- Salesforce Connector
- REST APIs
- Postman
- Maven
- Java 17

## Features

- Retrieve Salesforce Account by ID
- Transform Salesforce data for ERP
- Sync Account data to mock ERP
- Structured JSON responses
- Basic validation and error handling
- Local end-to-end testing

## Architecture

```text
Client / Postman
      |
      v
MuleSoft API
      |
      +----> Salesforce (get Account)
      |
      v
DataWeave Transformation
      |
      v
Mock ERP API
```

## API Endpoint

**Method**
```http
POST
```

**Endpoint**
```http
http://localhost:8081/api/accounts/sync/{id}
```

**Example**
```http
POST http://localhost:8081/api/accounts/sync/001XXXXXXXXXXXXXXX
```

## Sample Success Response

```json
{
  "correlationId": "7f50c5a3-1c46-4b6c-a7f6-8bc1d29f9d11",
  "status": "SUCCESS",
  "salesforceAccountId": "001XXXXXXXXXXXXXXX",
  "erpSync": {
    "status": "SYNCED",
    "message": "Account synced successfully"
  }
}
```

## Sample ERP Payload

```json
{
  "externalId": "001XXXXXXXXXXXXXXX",
  "accountName": "Acme Corporation",
  "phone": "1234567890",
  "website": "https://acme.example.com",
  "billingCity": "Dallas",
  "billingCountry": "USA"
}
```

## Prerequisites

- Java 17
- Maven
- Anypoint Studio
- Salesforce Developer Org
- Mock ERP API running locally
- Postman

## Configuration

Update your local config with Salesforce and ERP values.

```properties
http.port=8081

salesforce.username=YOUR_SALESFORCE_USERNAME
salesforce.password=YOUR_SALESFORCE_PASSWORD
salesforce.securityToken=YOUR_SECURITY_TOKEN
salesforce.loginUrl=https://login.salesforce.com

erp.host=localhost
erp.port=8082
erp.basePath=/api
```

## How to Run

1. Clone the repository
2. Open it in Anypoint Studio
3. Update the config values
4. Make sure the mock ERP service is running
5. Run the Mule application
6. Test the endpoint using Postman or curl

## Test Example

```bash
curl --location --request POST 'http://localhost:8081/api/accounts/sync/001XXXXXXXXXXXXXXX'
```

## What This Project Shows

- Salesforce to MuleSoft integration
- DataWeave transformation
- API orchestration
- CRM to ERP sync pattern
- Error handling and traceability

## Future Improvements

- Retry for transient failures
- Secure properties for secrets
- MUnit tests
- Bulk sync support
- CloudHub deployment
