{
  "rules": [
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
          "varName": "GPU_A_OK",
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
          "varName": "CPU_A_OK",
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
          "varName": "CPU",
          "type": "STRING",
          "operation": "EQ",
          "value": "DualCore"
        },
        {
          "varName": "RAM",
          "type": "NUMBER",
          "operation": "LESS_EQ",
          "value": 4.0
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
          "varName": "CPU_A_OK",
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
          "varName": "hard_drive_buy",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        },
        {
          "varName": "CPU_RAM_limit_exceeded",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": false
        },
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
          "varName": "CPU",
          "type": "STRING",
          "operation": "NEQ",
          "value": "None"
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
      "name": "CPUNone",
      "antecedents": [
        {
          "varName": "CPU",
          "type": "STRING",
          "operation": "EQ",
          "value": "None"
        }
      ],
      "consequences": [
        {
          "varName": "CPU_A_OK",
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
          "varName": "CPU",
          "type": "STRING",
          "operation": "EQ",
          "value": "i3"
        },
        {
          "varName": "i3_A",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        }
      ],
      "consequences": [
        {
          "varName": "CPU_A_OK",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        }
      ]
    },
    {
      "name": "mouseYes",
      "antecedents": [
        {
          "varName": "mouse_A",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        },
        {
          "varName": "mouse",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        }
      ],
      "consequences": [
        {
          "varName": "mouse_A_OK",
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
          "varName": "CPU",
          "type": "STRING",
          "operation": "EQ",
          "value": "Pentium"
        },
        {
          "varName": "RAM",
          "type": "NUMBER",
          "operation": "LESS_EQ",
          "value": 4.0
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
          "varName": "CPU_A_OK",
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
          "varName": "CPU",
          "type": "STRING",
          "operation": "EQ",
          "value": "Ryzen3"
        },
        {
          "varName": "Ryzen3_A",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        }
      ],
      "consequences": [
        {
          "varName": "CPU_A_OK",
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
          "varName": "Ryzen5_A",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        },
        {
          "varName": "CPU",
          "type": "STRING",
          "operation": "EQ",
          "value": "Ryzen5"
        }
      ],
      "consequences": [
        {
          "varName": "CPU_A_OK",
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
          "varName": "buildable",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        },
        {
          "varName": "enough_budget",
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
      "name": "KeyboardYes",
      "antecedents": [
        {
          "varName": "keyboard",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        },
        {
          "varName": "keyboard_A",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        }
      ],
      "consequences": [
        {
          "varName": "keyboard_A_OK",
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
          "varName": "GPU_A_OK",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        }
      ]
    },
    {
      "name": "keyboardNo",
      "antecedents": [
        {
          "varName": "keyboard",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": false
        }
      ],
      "consequences": [
        {
          "varName": "keyboard_A_OK",
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
          "varName": "mouse_A_OK",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        },
        {
          "varName": "GPU_A_OK",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        },
        {
          "varName": "CPU_A_OK",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        },
        {
          "varName": "keyboard_A_OK",
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
      "name": "mouseNo",
      "antecedents": [
        {
          "varName": "mouse",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": false
        }
      ],
      "consequences": [
        {
          "varName": "mouse_A_OK",
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
          "varName": "GPU_A_OK",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
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
          "varName": "GPU_A_OK",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
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
          "varName": "CPU_A_OK",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        }
      ]
    },
    {
      "name": "GPUNone",
      "antecedents": [
        {
          "varName": "GPU",
          "type": "STRING",
          "operation": "EQ",
          "value": "None"
        }
      ],
      "consequences": [
        {
          "varName": "GPU_buy",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": false
        },
        {
          "varName": "GPU_A_OK",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        }
      ]
    },
    {
      "name": "i7_A",
      "antecedents": [
        {
          "varName": "i7_A",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        },
        {
          "varName": "CPU",
          "type": "STRING",
          "operation": "EQ",
          "value": "i7"
        }
      ],
      "consequences": [
        {
          "varName": "CPU_A_OK",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        }
      ]
    }
  ],
  "knowledgeBase": []
}