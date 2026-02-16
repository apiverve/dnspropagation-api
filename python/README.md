DNS Propagation Checker API
============

DNS Propagation Checker verifies if DNS changes have propagated across multiple global DNS servers. It queries DNS servers worldwide to show the current state of your DNS records.

![Build Status](https://img.shields.io/badge/build-passing-green)
![Code Climate](https://img.shields.io/badge/maintainability-B-purple)
![Prod Ready](https://img.shields.io/badge/production-ready-blue)

This is a Python API Wrapper for the [DNS Propagation Checker API](https://apiverve.com/marketplace/dnspropagation?utm_source=pypi&utm_medium=readme)

---

## Installation

Using `pip`:

```bash
pip install apiverve-dnspropagationchecker
```

Using `pip3`:

```bash
pip3 install apiverve-dnspropagationchecker
```

---

## Configuration

Before using the dnspropagation API client, you have to setup your account and obtain your API Key.
You can get it by signing up at [https://apiverve.com](https://apiverve.com?utm_source=pypi&utm_medium=readme)

---

## Quick Start

Here's a simple example to get you started quickly:

```python
from apiverve_dnspropagationchecker.apiClient import DnspropagationAPIClient

# Initialize the client with your APIVerve API key
api = DnspropagationAPIClient("[YOUR_API_KEY]")

query = {
    "domain": "google.com",
    "type": "A"
}

try:
    # Make the API call
    result = api.execute(query)

    # Print the result
    print(result)
except Exception as e:
    print(f"Error: {e}")
```

---

## Usage

The DNS Propagation Checker API documentation is found here: [https://docs.apiverve.com/ref/dnspropagation](https://docs.apiverve.com/ref/dnspropagation?utm_source=pypi&utm_medium=readme).
You can find parameters, example responses, and status codes documented here.

### Setup

```python
# Import the client module
from apiverve_dnspropagationchecker.apiClient import DnspropagationAPIClient

# Initialize the client with your APIVerve API key
api = DnspropagationAPIClient("[YOUR_API_KEY]")
```

---

## Perform Request

Using the API client, you can perform requests to the API.

###### Define Query

```python
query = {
    "domain": "google.com",
    "type": "A"
}
```

###### Simple Request

```python
# Make a request to the API
result = api.execute(query)

# Print the result
print(result)
```

###### Example Response

```json
{
  "status": "ok",
  "error": null,
  "data": {
    "domain": "google.com",
    "recordType": "A",
    "propagationComplete": true,
    "serversChecked": 10,
    "serversResponded": 10,
    "uniqueResponses": 1,
    "results": [
      {
        "server": "Google",
        "location": "United States",
        "ip": "8.8.8.8",
        "success": true,
        "records": [
          "142.250.80.46"
        ],
        "error": null,
        "responseTime": 23
      },
      {
        "server": "Cloudflare",
        "location": "Global",
        "ip": "1.1.1.1",
        "success": true,
        "records": [
          "142.250.80.46"
        ],
        "error": null,
        "responseTime": 18
      },
      {
        "server": "OpenDNS",
        "location": "United States",
        "ip": "208.67.222.222",
        "success": true,
        "records": [
          "142.250.80.46"
        ],
        "error": null,
        "responseTime": 31
      },
      {
        "server": "Quad9",
        "location": "Global",
        "ip": "9.9.9.9",
        "success": true,
        "records": [
          "142.250.80.46"
        ],
        "error": null,
        "responseTime": 25
      },
      {
        "server": "Comodo",
        "location": "United States",
        "ip": "8.26.56.26",
        "success": true,
        "records": [
          "142.250.80.46"
        ],
        "error": null,
        "responseTime": 42
      },
      {
        "server": "Level3",
        "location": "United States",
        "ip": "4.2.2.1",
        "success": true,
        "records": [
          "142.250.80.46"
        ],
        "error": null,
        "responseTime": 28
      },
      {
        "server": "Verisign",
        "location": "United States",
        "ip": "64.6.64.6",
        "success": true,
        "records": [
          "142.250.80.46"
        ],
        "error": null,
        "responseTime": 35
      },
      {
        "server": "DNS.Watch",
        "location": "Germany",
        "ip": "84.200.69.80",
        "success": true,
        "records": [
          "142.250.80.46"
        ],
        "error": null,
        "responseTime": 89
      },
      {
        "server": "Yandex",
        "location": "Russia",
        "ip": "77.88.8.8",
        "success": true,
        "records": [
          "142.250.80.46"
        ],
        "error": null,
        "responseTime": 112
      },
      {
        "server": "Hurricane Electric",
        "location": "United States",
        "ip": "74.82.42.42",
        "success": true,
        "records": [
          "142.250.80.46"
        ],
        "error": null,
        "responseTime": 29
      }
    ]
  }
}
```

---

## Error Handling

The API client provides comprehensive error handling through the `DnspropagationAPIClientError` exception. Here are some examples:

### Basic Error Handling

```python
from apiverve_dnspropagationchecker.apiClient import DnspropagationAPIClient, DnspropagationAPIClientError

api = DnspropagationAPIClient("[YOUR_API_KEY]")

query = {
    "domain": "google.com",
    "type": "A"
}

try:
    result = api.execute(query)
    print("Success!")
    print(result)
except DnspropagationAPIClientError as e:
    print(f"API Error: {e.message}")
    if e.status_code:
        print(f"Status Code: {e.status_code}")
    if e.response:
        print(f"Response: {e.response}")
```

### Handling Specific Error Types

```python
from apiverve_dnspropagationchecker.apiClient import DnspropagationAPIClient, DnspropagationAPIClientError

api = DnspropagationAPIClient("[YOUR_API_KEY]")

query = {
    "domain": "google.com",
    "type": "A"
}

try:
    result = api.execute(query)

    # Check for successful response
    if result.get('status') == 'success':
        print("Request successful!")
        print(result.get('data'))
    else:
        print(f"API returned an error: {result.get('error')}")

except DnspropagationAPIClientError as e:
    # Handle API client errors
    if e.status_code == 401:
        print("Unauthorized: Invalid API key")
    elif e.status_code == 429:
        print("Rate limit exceeded")
    elif e.status_code >= 500:
        print("Server error - please try again later")
    else:
        print(f"API error: {e.message}")
except Exception as e:
    # Handle unexpected errors
    print(f"Unexpected error: {str(e)}")
```

### Using Context Manager (Recommended)

The client supports the context manager protocol for automatic resource cleanup:

```python
from apiverve_dnspropagationchecker.apiClient import DnspropagationAPIClient, DnspropagationAPIClientError

query = {
    "domain": "google.com",
    "type": "A"
}

# Using context manager ensures proper cleanup
with DnspropagationAPIClient("[YOUR_API_KEY]") as api:
    try:
        result = api.execute(query)
        print(result)
    except DnspropagationAPIClientError as e:
        print(f"Error: {e.message}")
# Session is automatically closed here
```

---

## Advanced Features

### Debug Mode

Enable debug logging to see detailed request and response information:

```python
from apiverve_dnspropagationchecker.apiClient import DnspropagationAPIClient

# Enable debug mode
api = DnspropagationAPIClient("[YOUR_API_KEY]", debug=True)

query = {
    "domain": "google.com",
    "type": "A"
}

# Debug information will be printed to console
result = api.execute(query)
```

### Manual Session Management

If you need to manually manage the session lifecycle:

```python
from apiverve_dnspropagationchecker.apiClient import DnspropagationAPIClient

api = DnspropagationAPIClient("[YOUR_API_KEY]")

query = {
    "domain": "google.com",
    "type": "A"
}

try:
    result = api.execute(query)
    print(result)
finally:
    # Manually close the session when done
    api.close()
```

---

## Customer Support

Need any assistance? [Get in touch with Customer Support](https://apiverve.com/contact?utm_source=pypi&utm_medium=readme).

---

## Updates
Stay up to date by following [@apiverveHQ](https://twitter.com/apiverveHQ) on Twitter.

---

## Legal

All usage of the APIVerve website, API, and services is subject to the [APIVerve Terms of Service](https://apiverve.com/terms?utm_source=pypi&utm_medium=readme) and all legal documents and agreements.

---

## License
Licensed under the The MIT License (MIT)

Copyright (&copy;) 2026 APIVerve, and EvlarSoft LLC

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
