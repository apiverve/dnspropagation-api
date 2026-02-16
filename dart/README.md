# DNS Propagation Checker API - Dart/Flutter Client

DNS Propagation Checker verifies if DNS changes have propagated across multiple global DNS servers. It queries DNS servers worldwide to show the current state of your DNS records.

[![pub package](https://img.shields.io/pub/v/apiverve_dnspropagation.svg)](https://pub.dev/packages/apiverve_dnspropagation)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

This is the Dart/Flutter client for the [DNS Propagation Checker API](https://apiverve.com/marketplace/dnspropagation?utm_source=dart&utm_medium=readme).

## Installation

Add this to your `pubspec.yaml`:

```yaml
dependencies:
  apiverve_dnspropagation: ^1.1.14
```

Then run:

```bash
dart pub get
# or for Flutter
flutter pub get
```

## Usage

```dart
import 'package:apiverve_dnspropagation/apiverve_dnspropagation.dart';

void main() async {
  final client = DnspropagationClient('YOUR_API_KEY');

  try {
    final response = await client.execute({
      'domain': 'google.com',
      'type': 'A'
    });

    print('Status: ${response.status}');
    print('Data: ${response.data}');
  } catch (e) {
    print('Error: $e');
  }
}
```

## Response

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

## API Reference

- **API Home:** [DNS Propagation Checker API](https://apiverve.com/marketplace/dnspropagation?utm_source=dart&utm_medium=readme)
- **Documentation:** [docs.apiverve.com/ref/dnspropagation](https://docs.apiverve.com/ref/dnspropagation?utm_source=dart&utm_medium=readme)

## Authentication

All requests require an API key. Get yours at [apiverve.com](https://apiverve.com?utm_source=dart&utm_medium=readme).

## License

MIT License - see [LICENSE](LICENSE) for details.

---

Built with Dart for [APIVerve](https://apiverve.com?utm_source=dart&utm_medium=readme)
