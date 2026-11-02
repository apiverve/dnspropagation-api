/// Response models for the DNS Propagation Checker API.

/// API Response wrapper.
class DnspropagationResponse {
  final String status;
  final dynamic error;
  final DnspropagationData? data;

  /// Set only when the current plan locks one or more fields; null otherwise.
  final PremiumInfo? premium;

  DnspropagationResponse({
    required this.status,
    this.error,
    this.data,
    this.premium,
  });

  factory DnspropagationResponse.fromJson(Map<String, dynamic> json) => DnspropagationResponse(
    status: json['status'] as String? ?? '',
    error: json['error'],
    data: json['data'] != null ? DnspropagationData.fromJson(json['data']) : null,
    premium: json['premium'] != null ? PremiumInfo.fromJson(json['premium']) : null,
  );

  Map<String, dynamic> toJson() => {
    'status': status,
    if (error != null) 'error': error,
    if (data != null) 'data': data,
    if (premium != null) 'premium': premium!.toJson(),
  };
}

/// Describes fields the current plan does not unlock. Locked fields arrive as null
/// in [data], and [lockedFields] names them (nested ones use dot paths).
class PremiumInfo {
  final String? message;
  final String? upgradeUrl;
  final List<String>? lockedFields;

  PremiumInfo({this.message, this.upgradeUrl, this.lockedFields});

  factory PremiumInfo.fromJson(Map<String, dynamic> json) => PremiumInfo(
    message: json['message'] as String?,
    upgradeUrl: json['upgrade_url'] as String?,
    lockedFields: (json['locked_fields'] as List?)?.map((e) => e.toString()).toList(),
  );

  Map<String, dynamic> toJson() => {
    if (message != null) 'message': message,
    if (upgradeUrl != null) 'upgrade_url': upgradeUrl,
    if (lockedFields != null) 'locked_fields': lockedFields,
  };
}

/// Response data for the DNS Propagation Checker API.

class DnspropagationData {
  String? domain;
  String? recordType;
  bool? propagationComplete;
  num? serversChecked;
  num? serversResponded;
  num? uniqueResponses;
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
  num? responseTime;

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
