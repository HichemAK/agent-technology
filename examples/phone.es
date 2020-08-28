{
  "rules": [
    {
      "name": "",
      "antecedents": [
        {
          "varName": "model",
          "type": "STRING",
          "operation": "EQ",
          "value": "Galaxy Fold"
        },
        {
          "varName": "Galaxy Fold_A",
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
      "name": "",
      "antecedents": [
        {
          "varName": "model",
          "type": "STRING",
          "operation": "EQ",
          "value": "Galaxy A"
        },
        {
          "varName": "Galaxy A_A",
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
      "name": "",
      "antecedents": [
        {
          "varName": "iPhone 9_A",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        },
        {
          "varName": "model",
          "type": "STRING",
          "operation": "EQ",
          "value": "iPhone 9"
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
      "name": "",
      "antecedents": [
        {
          "varName": "Galaxy S_A",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        },
        {
          "varName": "model",
          "type": "STRING",
          "operation": "EQ",
          "value": "Galaxy S"
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
      "name": "purchase",
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
      "name": "",
      "antecedents": [
        {
          "varName": "Galaxy Note_A",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        },
        {
          "varName": "model",
          "type": "STRING",
          "operation": "EQ",
          "value": "Galaxy Note"
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
      "name": "",
      "antecedents": [
        {
          "varName": "iPhone 8_A",
          "type": "BOOLEAN",
          "operation": "EQ",
          "value": true
        },
        {
          "varName": "model",
          "type": "STRING",
          "operation": "EQ",
          "value": "iPhone 8"
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
      "name": "",
      "antecedents": [
        {
          "varName": "model",
          "type": "STRING",
          "operation": "EQ",
          "value": "iPhone 6s"
        },
        {
          "varName": "iPhone 6s_A",
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
      "name": "",
      "antecedents": [
        {
          "varName": "model",
          "type": "STRING",
          "operation": "EQ",
          "value": "iPhone 7 Plus"
        },
        {
          "varName": "iPhone 7 Plus_A",
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
    }
  ],
  "knowledgeBase": []
}