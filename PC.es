{
  "rules": [
    {
      "name": "i7_A",
      "antecedents": [
        {
          "varName": "CPU",
          "type": "STRING",
          "operation": "EQ",
          "value": "i7"
        },
        {
          "varName": "i7_A",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        }
      ],
      "consequences": [
        {
          "varName": "CPU_A",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        }
      ]
    },
    {
      "name": "Ryzen3_A",
      "antecedents": [
        {
          "varName": "Ryzen3_A",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        },
        {
          "varName": "CPU",
          "type": "STRING",
          "operation": "EQ",
          "value": "Ryzen3"
        }
      ],
      "consequences": [
        {
          "varName": "CPU_A",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        }
      ]
    },
    {
      "name": "Purchase Possible",
      "antecedents": [
        {
          "varName": "enough_budget",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        },
        {
          "varName": "buildable",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        },
        {
          "varName": "availability",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        }
      ],
      "consequences": [
        {
          "varName": "purchase_possible",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        }
      ]
    },
    {
      "name": "Radeon_A",
      "antecedents": [
        {
          "varName": "GPU",
          "type": "STRING",
          "operation": "EQ",
          "value": "Radeon"
        },
        {
          "varName": "Radeon_A",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        }
      ],
      "consequences": [
        {
          "varName": "GPU_A",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        }
      ]
    },
    {
      "name": "Ryzen5_A",
      "antecedents": [
        {
          "varName": "CPU",
          "type": "STRING",
          "operation": "EQ",
          "value": "Ryzen5"
        },
        {
          "varName": "Ryzen5_A",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        }
      ],
      "consequences": [
        {
          "varName": "CPU_A",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        }
      ]
    },
    {
      "name": "Pentium_A",
      "antecedents": [
        {
          "varName": "CPU",
          "type": "STRING",
          "operation": "EQ",
          "value": "Pentium"
        },
        {
          "varName": "Pentium_A",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        }
      ],
      "consequences": [
        {
          "varName": "CPU_A",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        }
      ]
    },
    {
      "name": "i3_A",
      "antecedents": [
        {
          "varName": "i3_A",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        },
        {
          "varName": "CPU",
          "type": "STRING",
          "operation": "EQ",
          "value": "i3"
        }
      ],
      "consequences": [
        {
          "varName": "CPU_A",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        }
      ]
    },
    {
      "name": "Availability",
      "antecedents": [
        {
          "varName": "CPU_A",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        },
        {
          "varName": "keyboard_A",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        },
        {
          "varName": "mouse_A",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        },
        {
          "varName": "GPU_A",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        }
      ],
      "consequences": [
        {
          "varName": "availability",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        }
      ]
    },
    {
      "name": "RTX_A",
      "antecedents": [
        {
          "varName": "GPU",
          "type": "STRING",
          "operation": "EQ",
          "value": "RTX"
        },
        {
          "varName": "RTX_A",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        }
      ],
      "consequences": [
        {
          "varName": "GPU_A",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        }
      ]
    },
    {
      "name": "Buildable",
      "antecedents": [
        {
          "varName": "MB_RAM_limit_exceeded",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": false
        },
        {
          "varName": "RAM",
          "type": "NUMBER",
          "operation": "GREAT",
          "value": 0.0
        },
        {
          "varName": "CPU_RAM_limit_exceeded",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": false
        }
      ],
      "consequences": [
        {
          "varName": "buildable",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        }
      ]
    },
    {
      "name": "RAM limit Pentium",
      "antecedents": [
        {
          "varName": "RAM",
          "type": "NUMBER",
          "operation": "LESS_EQ",
          "value": 4.0
        },
        {
          "varName": "CPU",
          "type": "STRING",
          "operation": "EQ",
          "value": "Pentium"
        }
      ],
      "consequences": [
        {
          "varName": "CPU_RAM_limit_exceeded",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": false
        }
      ]
    },
    {
      "name": "Ryzen7_A",
      "antecedents": [
        {
          "varName": "Ryzen7_A",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        },
        {
          "varName": "CPU",
          "type": "STRING",
          "operation": "EQ",
          "value": "Ryzen7"
        }
      ],
      "consequences": [
        {
          "varName": "CPU_A",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        }
      ]
    },
    {
      "name": "i5_A",
      "antecedents": [
        {
          "varName": "CPU",
          "type": "STRING",
          "operation": "EQ",
          "value": "i5"
        },
        {
          "varName": "i5_A",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        }
      ],
      "consequences": [
        {
          "varName": "CPU_A",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        }
      ]
    },
    {
      "name": "RAM limit DualCore",
      "antecedents": [
        {
          "varName": "RAM",
          "type": "NUMBER",
          "operation": "LESS_EQ",
          "value": 4.0
        },
        {
          "varName": "CPU",
          "type": "STRING",
          "operation": "EQ",
          "value": "DualCore"
        }
      ],
      "consequences": [
        {
          "varName": "CPU_RAM_limit_exceeded",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": false
        }
      ]
    },
    {
      "name": "RAM limit Motherboard",
      "antecedents": [
        {
          "varName": "RAM",
          "type": "NUMBER",
          "operation": "LESS_EQ",
          "value": 64.0
        }
      ],
      "consequences": [
        {
          "varName": "MB_RAM_limit_exceeded",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": false
        }
      ]
    },
    {
      "name": "GTX_A",
      "antecedents": [
        {
          "varName": "GTX_A",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        },
        {
          "varName": "GPU",
          "type": "STRING",
          "operation": "EQ",
          "value": "GTX"
        }
      ],
      "consequences": [
        {
          "varName": "GPU_A",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        }
      ]
    },
    {
      "name": "Titan_A",
      "antecedents": [
        {
          "varName": "GPU",
          "type": "STRING",
          "operation": "EQ",
          "value": "Titan"
        },
        {
          "varName": "Titan_A",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        }
      ],
      "consequences": [
        {
          "varName": "GPU_A",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        }
      ]
    },
    {
      "name": "DualCore_A",
      "antecedents": [
        {
          "varName": "DualCore_A",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        },
        {
          "varName": "CPU",
          "type": "STRING",
          "operation": "EQ",
          "value": "DualCore"
        }
      ],
      "consequences": [
        {
          "varName": "CPU_A",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        }
      ]
    }
  ],
  "knowledgeBase": []
}