declare module '@apiverve/dnspropagation' {
  export interface dnspropagationOptions {
    api_key: string;
    secure?: boolean;
  }

  export interface dnspropagationResponse {
    status: string;
    error: string | null;
    data: DNSPropagationCheckerData;
    code?: number;
  }


  interface DNSPropagationCheckerData {
      domain:              string;
      recordType:          string;
      propagationComplete: boolean;
      serversChecked:      number;
      serversResponded:    number;
      uniqueResponses:     number;
      results:             Result[];
  }
  
  interface Result {
      server:       string;
      location:     string;
      ip:           string;
      success:      boolean;
      records:      Record[];
      error:        null;
      responseTime: number;
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
