//
//  Stopwatch.swift
//  MW1_McQuade_Michael
//
//  Created by Michael E McQuade on 9/27/18.
//  Copyright © 2018 giraffesyo.io. All rights reserved.
//

import UIKit


class Stopwatch: NSObject {
    
    private var laps: Int
    private var time: Double
    private var formatter: DateFormatter
    
    override init() {
        self.laps = 0
        self.time = 0
        self.formatter = DateFormatter.init()
        
    }
    
    func getLaps() -> Int {
        return laps
    }
    
    func getTime() -> Double {
        return time
    }
    
    /*func getFormattedTime() -> String {
        
    }*/
    
    //Sets the time and returns the previous time
    func setTime(time: Double) -> Double {
        let oldTime = self.time
        self.time = time
        return oldTime
    }
    
    // incrememnts laps by one and returns new lap amount
    func incrementLap() -> Int {
        self.laps = self.laps + 1
        return self.laps
    }
}
