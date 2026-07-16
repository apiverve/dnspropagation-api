# DNS Propagation Checker API - PHP Package

DNS Propagation Checker verifies if DNS changes have propagated across multiple global DNS servers. It queries DNS servers worldwide to show the current state of your DNS records.

## Installation

Install via Composer:

```bash
composer require apiverve/dnspropagation
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```php
<?php

require_once 'vendor/autoload.php';

use APIVerve\Dnspropagation\Client;

// Initialize the client
$client = new Client('YOUR_API_KEY');

// Make a request
$response = $client->execute([
    'domain' => 'google.com',
    'type' => 'A'
]);

// Print the response
print_r($response);
```


### Error Handling

```php
use APIVerve\Dnspropagation\Client;
use APIVerve\Dnspropagation\Exceptions\APIException;
use APIVerve\Dnspropagation\Exceptions\ValidationException;

try {
    $response = $client->execute(['domain' => 'google.com', 'type' => 'A']);
    print_r($response['data']);
} catch (ValidationException $e) {
    echo "Validation error: " . implode(', ', $e->getErrors());
} catch (APIException $e) {
    echo "API error: " . $e->getMessage();
    echo "Status code: " . $e->getStatusCode();
}
```

### Debug Mode

```php
// Enable debug logging
$client = new Client(
    apiKey: 'YOUR_API_KEY',
    debug: true
);
```

## Example Response

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

## Requirements

- PHP 7.4 or higher
- Guzzle HTTP client

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/dnspropagation?utm_source=packagist&utm_medium=readme).

## Support

- Website: [https://dnspropagation.apiverve.com?utm_source=php&utm_medium=readme](https://dnspropagation.apiverve.com?utm_source=php&utm_medium=readme)
- Email: hello@apiverve.com

## License

This package is available under the [MIT License](LICENSE).
