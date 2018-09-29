//
//  Stopwatch.swift
//  MW1_McQuade_Michael
//
//  Created by Michael E McQuade on 9/27/18.
//  Copyright © 2018 giraffesyo.io. All rights reserved.
//

import UIKit


class Stopwatch: NSObject {
    
    
    // laps will store the amount of time each lap took, measured in deciseconds
    private var laps: [Int]
    private var totalTime: Int
    private var formatter: DateComponentsFormatter
    public var active: Bool
 
    override init() {
        self.active = false
        self.laps = []
        self.totalTime = 0
        //Documentation for allowed units at https://developer.apple.com/documentation/foundation/datecomponentsformatter
        self.formatter = DateComponentsFormatter.init()
        formatter.allowsFractionalUnits = false
        formatter.allowedUnits = [.hour, .minute, .second]
        formatter.unitsStyle = .positional
        formatter.zeroFormattingBehavior = .pad
        
    }
    
    func getLapCount() -> Int {
        return laps.count
    }
    
    func getLapTimeInDeciseconds(lap: Int) -> Int {
        return self.laps[lap]
    }
    
    func nextLap() {
        laps.append(0)
    }
    
    //Sets the lap time for given lap
    func updateLapTime(lap: Int, time: Int) -> Void {
        self.laps[lap] = time
    }
    
    //Increment time by 1 decisecond
    func incrementLapTimeByDecisecond(lap: Int) -> Void {
        let currentTime = self.laps[lap]
        self.totalTime = self.totalTime + 1
        updateLapTime(lap: lap, time: currentTime + 1)
    }
    
    //Returns a formatted time string given a lap number
    func getFormattedTimeForLap(lap: Int) -> String {
        let time = self.laps[lap]
        return getFormattedTimeFromDeciseconds(time: time)
    }
    
    func getFormattedTotalTime() -> String {
        return getFormattedTimeFromDeciseconds(time: totalTime)
    }
    
    
    //Returns a formatted string given deciseconds
    private func getFormattedTimeFromDeciseconds(time: Int) -> String {
        //Divide time by 10 to get time in seconds
        let timeWithoutDeciseconds = formatter.string(from: TimeInterval(time/10))!
        let deciseconds = String(time % 10)
        return "\(timeWithoutDeciseconds).\(deciseconds)"
    }
    
    //set laps and totaltime back to initial values
    func restart() {
        self.active = false
        self.laps = []
        self.totalTime = 0
    }

}
