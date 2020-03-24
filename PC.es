{
  "rules": [
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
      "name": "Radeon_A",
      "antecedents": [
        {
          "varName": "Radeon_A",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        },
        {
          "varName": "GPU",
          "type": "STRING",
          "operation": "EQ",
          "value": "Radeon"
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
          "varName": "GPU_A_OK",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        }
      ]
    },
    {
      "name": "RAM No",
      "antecedents": [
        {
          "varName": "RAM",
          "type": "NUMBER",
          "operation": "EQ",
          "value": 0.0
        }
      ],
      "consequences": [
        {
          "varName": "RAM_A_OK",
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
          "varName": "Pentium_A",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
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
      "name": "Availability",
      "antecedents": [
        {
          "varName": "mouse_A_OK",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        },
        {
          "varName": "keyboard_A_OK",
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
      "name": "Buildable",
      "antecedents": [
        {
          "varName": "CPU",
          "type": "STRING",
          "operation": "NEQ",
          "value": "None"
        },
        {
          "varName": "hard_drive_buy",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
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
      "name": "RAM Yes",
      "antecedents": [
        {
          "varName": "RAM",
          "type": "NUMBER",
          "operation": "GREAT",
          "value": 0.0
        },
        {
          "varName": "RAM_A",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        }
      ],
      "consequences": [
        {
          "varName": "RAM_A_OK",
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
          "varName": "CPU_A_OK",
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
      "name": "KeyboardYes",
      "antecedents": [
        {
          "varName": "keyboard_A",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        },
        {
          "varName": "keyboard",
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
          "varName": "RTX_A",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        },
        {
          "varName": "GPU",
          "type": "STRING",
          "operation": "EQ",
          "value": "RTX"
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
      "name": "Purchase Possible",
      "antecedents": [
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
        },
        {
          "varName": "buildable",
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
      "name": "mouseYes",
      "antecedents": [
        {
          "varName": "mouse",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        },
        {
          "varName": "mouse_A",
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
    }
  ],
  "knowledgeBase": []
}