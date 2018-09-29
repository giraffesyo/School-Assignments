//
//  ViewController.swift
//  MW1_McQuade_Michael
//
//  Created by Michael E McQuade on 9/27/18.
//  Copyright © 2018 giraffesyo.io. All rights reserved.
//

import UIKit

class TimerViewController: UIViewController {
    
    @IBOutlet var lapNumberLabel: UILabel!
    @IBOutlet var LapTimeLabel: UILabel!
    @IBOutlet var TotalLapTimeLabel: UILabel!
    
    //create instance of our stopwatch class
    var stopwatch: Stopwatch = Stopwatch()
    //create a timer which we will use to update our stopwatch
    var timer: Timer = Timer.init()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
    }
    
    @IBAction func StartStopButtonPressed(_ sender: UIButton) {
        //escape if for some reason the title label isn't there
        guard let nextState = sender.titleLabel!.text else {
            print("nextState returned nil, starting watch")
            start(startbutton: sender)
            return
        }
        //call the appropriate function based on current state
        switch(nextState){
        case "START":
            start(startbutton: sender)
            break
        case "STOP":
            stop(stopbutton: sender)
            break
        default:
            print("Default case was reached within StartStopButtonPressed function, value of nextState is \(nextState)")
            break
        }
    }
    
    func start(startbutton: UIButton) {
        //start the stopwatch if its our first lap
        if stopwatch.getLapCount() == 0{
            stopwatch.start()}
        startbutton.setTitle("STOP", for: UIControl.State.normal)
        startbutton.setTitleColor(UIColor.red, for: UIControl.State.normal)

        let currentLapIndex = stopwatch.getLapCount() - 1
        timer = Timer.scheduledTimer(withTimeInterval: 0.1, repeats: true, block: {_ in
            self.stopwatch.incrementLapTimeByDecisecond(lap: currentLapIndex)
            self.LapTimeLabel.text = self.stopwatch.getFormattedTimeForLap(lap: currentLapIndex)
        })
        lapNumberLabel.text = String(stopwatch.getLapCount())
        
    }
    
    func stop(stopbutton: UIButton) {
        //stop the timer
        timer.invalidate()
        stopbutton.setTitle("START", for: UIControl.State.normal)
        stopbutton.setTitleColor(UIColor.green, for: UIControl.State.normal)
    }
    
}

