declare module '@apiverve/dnspropagation' {
  export interface dnspropagationOptions {
    api_key: string;
    secure?: boolean;
  }

  /**
   * Describes fields the current plan does not unlock. Locked fields arrive as null
   * in `data`; `locked_fields` names them, using dot paths for nested fields.
   * Absent when the plan unlocks everything.
   */
  export interface PremiumInfo {
    message: string;
    upgrade_url: string;
    locked_fields: string[];
  }

  export interface dnspropagationResponse {
    status: string;
    error: string | null;
    data: DNSPropagationCheckerData;
    code?: number;
    premium?: PremiumInfo;
  }


  interface DNSPropagationCheckerData {
      domain:              null | string;
      recordType:          null | string;
      propagationComplete: boolean | null;
      serversChecked:      number | null;
      serversResponded:    number | null;
      uniqueResponses:     number | null;
      results:             Result[];
  }
  
  interface Result {
      server:       null | string;
      location:     null | string;
      ip:           null | string;
      success:      boolean | null;
      records:      (Record | null)[];
      error:        null;
      responseTime: number | null;
  }
  
  enum Record {
      The1422508046 = "142.250.80.46",
  }

  export default class dnspropagationWrapper {
    constructor(options: dnspropagationOptions);

    execute(callback: (error: any, data: dnspropagationResponse | null) => void): Promise<dnspropagationResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: dnspropagationResponse | null) => void): Promise<dnspropagationResponse>;
    execute(query?: Record<string, any>): Promise<dnspropagationResponse>;
  }
}
