//
//  Cash.swift
//  w01_mcquade_michael
//
//  Created by Michael McQuade on 8/25/18.
//  Copyright © 2018 Michael McQuade. All rights reserved.
//

import Foundation


public class Cash {
    private var changeDue: Double = 0.0
    public func getBills() -> [Int]? {
        var remainingMoney = self.changeDue
        if remainingMoney < 0 {
            return nil
        }
        var bills = Array(repeating: 0, count: 9)
        
        let denominations = [50, 20, 10, 5, 1, 0.25, 0.10, 0.05, 0.01]
        
        for (index, denomination) in denominations.enumerated() {
            while remainingMoney >= denomination {
                remainingMoney -= denomination
                bills[index] = bills[index] + 1
            }
            
        }
        return bills
    }
    
    public init(money: Double){
        self.changeDue = money
    }
}
