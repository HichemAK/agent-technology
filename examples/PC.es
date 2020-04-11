{
  "rules": [
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
          "varName": "CPU_A_OK",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        }
      ]
    },
    {
      "name": "SSD1024_A",
      "antecedents": [
        {
          "varName": "HD",
          "type": "STRING",
          "operation": "EQ",
          "value": "SSD_1024"
        },
        {
          "varName": "SSD1024_A",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        }
      ],
      "consequences": [
        {
          "varName": "HD_A_OK",
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
          "varName": "GPU_A_OK",
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
          "varName": "CPU_A_OK",
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
      "name": "Ryzen7_A",
      "antecedents": [
        {
          "varName": "CPU",
          "type": "STRING",
          "operation": "EQ",
          "value": "Ryzen7"
        },
        {
          "varName": "Ryzen7_A",
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
      "name": "SSD256_A",
      "antecedents": [
        {
          "varName": "SSD256_A",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        },
        {
          "varName": "HD",
          "type": "STRING",
          "operation": "EQ",
          "value": "SSD256"
        }
      ],
      "consequences": [
        {
          "varName": "HD_A_OK",
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
      "name": "HDD1024_A",
      "antecedents": [
        {
          "varName": "HDD1024_A",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        },
        {
          "varName": "HD",
          "type": "STRING",
          "operation": "EQ",
          "value": "HDD1024"
        }
      ],
      "consequences": [
        {
          "varName": "HD_A_OK",
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
      "name": "Buildable",
      "antecedents": [
        {
          "varName": "CPU",
          "type": "STRING",
          "operation": "NEQ",
          "value": "None"
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
        },
        {
          "varName": "HD",
          "type": "STRING",
          "operation": "NEQ",
          "value": "None"
        },
        {
          "varName": "MB_RAM_limit_exceeded",
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
      "name": "HDD256_A",
      "antecedents": [
        {
          "varName": "HDD256_A",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        },
        {
          "varName": "HD",
          "type": "STRING",
          "operation": "EQ",
          "value": "HDD256"
        }
      ],
      "consequences": [
        {
          "varName": "HD_A_OK",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        }
      ]
    },
    {
      "name": "",
      "antecedents": [
        {
          "varName": "CPU",
          "type": "STRING",
          "operation": "NEQ",
          "value": "DualCore"
        },
        {
          "varName": "CPU",
          "type": "STRING",
          "operation": "NEQ",
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
      "name": "Availability",
      "antecedents": [
        {
          "varName": "mouse_A_OK",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        },
        {
          "varName": "HD_A_OK",
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
          "varName": "CPU_A_OK",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        },
        {
          "varName": "GPU_A_OK",
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
      "name": "Purchase Possible",
      "antecedents": [
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
        },
        {
          "varName": "enough_budget",
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
      "name": "HD None",
      "antecedents": [
        {
          "varName": "HD",
          "type": "STRING",
          "operation": "EQ",
          "value": "None"
        }
      ],
      "consequences": [
        {
          "varName": "HD_A_OK",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        }
      ]
    },
    {
      "name": "SSD512_A",
      "antecedents": [
        {
          "varName": "SSD512_A",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        },
        {
          "varName": "HD",
          "type": "STRING",
          "operation": "EQ",
          "value": "SSD512"
        }
      ],
      "consequences": [
        {
          "varName": "HD_A_OK",
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
      "name": "HDD512_A",
      "antecedents": [
        {
          "varName": "HD",
          "type": "STRING",
          "operation": "EQ",
          "value": "HDD512"
        },
        {
          "varName": "HDD512_A",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        }
      ],
      "consequences": [
        {
          "varName": "HD_A_OK",
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
    }
  ],
  "knowledgeBase": []
}