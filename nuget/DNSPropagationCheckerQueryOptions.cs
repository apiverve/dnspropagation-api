using System;
using System.Collections.Generic;
using System.Text;
using Newtonsoft.Json;

namespace APIVerve.API.DNSPropagationChecker
{
    /// <summary>
    /// Query options for the DNS Propagation Checker API
    /// </summary>
    public class DNSPropagationCheckerQueryOptions
    {
        /// <summary>
        /// The domain name to check propagation for
        /// </summary>
        [JsonProperty("domain")]
        public string Domain { get; set; }

        /// <summary>
        /// The DNS record type to check
        /// </summary>
        [JsonProperty("type")]
        public string Type { get; set; }
    }
}
