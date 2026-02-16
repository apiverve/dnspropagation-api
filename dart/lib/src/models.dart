/// Response models for the DNS Propagation Checker API.

/// API Response wrapper.
class DnspropagationResponse {
  final String status;
  final dynamic error;
  final DnspropagationData? data;

  DnspropagationResponse({
    required this.status,
    this.error,
    this.data,
  });

  factory DnspropagationResponse.fromJson(Map<String, dynamic> json) => DnspropagationResponse(
    status: json['status'] as String? ?? '',
    error: json['error'],
    data: json['data'] != null ? DnspropagationData.fromJson(json['data']) : null,
  );

  Map<String, dynamic> toJson() => {
    'status': status,
    if (error != null) 'error': error,
    if (data != null) 'data': data,
  };
}

/// Response data for the DNS Propagation Checker API.

class DnspropagationData {
  String? domain;
  String? recordType;
  bool? propagationComplete;
  int? serversChecked;
  int? serversResponded;
  int? uniqueResponses;
  List<DnspropagationDataResultsItem>? results;

  DnspropagationData({
    this.domain,
    this.recordType,
    this.propagationComplete,
    this.serversChecked,
    this.serversResponded,
    this.uniqueResponses,
    this.results,
  });

  factory DnspropagationData.fromJson(Map<String, dynamic> json) => DnspropagationData(
      domain: json['domain'],
      recordType: json['recordType'],
      propagationComplete: json['propagationComplete'],
      serversChecked: json['serversChecked'],
      serversResponded: json['serversResponded'],
      uniqueResponses: json['uniqueResponses'],
      results: (json['results'] as List?)?.map((e) => DnspropagationDataResultsItem.fromJson(e)).toList(),
    );
}

class DnspropagationDataResultsItem {
  String? server;
  String? location;
  String? ip;
  bool? success;
  List<String>? records;
  dynamic error;
  int? responseTime;

  DnspropagationDataResultsItem({
    this.server,
    this.location,
    this.ip,
    this.success,
    this.records,
    this.error,
    this.responseTime,
  });

  factory DnspropagationDataResultsItem.fromJson(Map<String, dynamic> json) => DnspropagationDataResultsItem(
      server: json['server'],
      location: json['location'],
      ip: json['ip'],
      success: json['success'],
      records: (json['records'] as List?)?.cast<String>(),
      error: json['error'],
      responseTime: json['responseTime'],
    );
}

class DnspropagationRequest {
  String domain;
  String? type;

  DnspropagationRequest({
    required this.domain,
    this.type,
  });

  Map<String, dynamic> toJson() => {
      'domain': domain,
      if (type != null) 'type': type,
    };
}
