# DNS Propagation Checker API - Ruby Gem

DNS Propagation Checker is a DNS checker API that verifies if DNS changes have propagated across multiple global DNS servers. It queries DNS servers worldwide to show the current state of your DNS records.

## Installation

Add this line to your application's Gemfile:

```ruby
gem 'apiverve_dnspropagation'
```

And then execute:

```bash
$ bundle install
```

Or install it yourself as:

```bash
$ gem install apiverve_dnspropagation
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```ruby
require 'apiverve_dnspropagation'

# Initialize the client
client = APIVerve::Dnspropagation::Client.new(api_key: "YOUR_API_KEY")

# Make a request
response = client.execute({
  domain: "google.com",
  type: "A"
})

# Print the response
puts response
```


### Error Handling

```ruby
begin
  response = client.execute({ domain: "google.com", type: "A" })
  puts response["data"]
rescue APIVerve::Dnspropagation::ValidationError => e
  puts "Validation error: #{e.errors.join(', ')}"
rescue APIVerve::Dnspropagation::APIError => e
  puts "API error: #{e.message}"
  puts "Status code: #{e.status_code}"
end
```

### Debug Mode

```ruby
# Enable debug logging
client = APIVerve::Dnspropagation::Client.new(
  api_key: "YOUR_API_KEY",
  debug: true
)
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
        "server": "Control D",
        "location": "Global",
        "ip": "76.76.2.0",
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
        "server": "DNS4EU",
        "location": "Europe",
        "ip": "86.54.11.100",
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

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/dnspropagation?utm_source=rubygems&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/dnspropagation?utm_source=ruby&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/dnspropagation?utm_source=ruby&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This gem is available under the [MIT License](LICENSE).
