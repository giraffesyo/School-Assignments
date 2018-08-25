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
        //We lose any value that is less than a penny by casting to Int (think stocks)
        var remainingMoney: Int = Int(self.changeDue * 100)
        if remainingMoney < 0 {
            return nil
        }
        var bills = Array(repeating: 0, count: 9)
        
        let denominations = [5000, 2000, 1000, 500, 100, 25, 10, 5, 1]
        
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
