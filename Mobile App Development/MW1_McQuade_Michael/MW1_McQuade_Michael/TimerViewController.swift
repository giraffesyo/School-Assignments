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
    @IBOutlet var LapTrackerButton: UIButton!
    @IBOutlet var StartStopButton: UIButton!
    
    //create instance of our stopwatch class
    var stopwatch: Stopwatch = Stopwatch()
    //create a timer which we will use to update our stopwatch
    var timer: Timer = Timer.init()
    
    override func viewDidLoad() {
        super.viewDidLoad()
    }
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(animated)
        self.navigationController?.isNavigationBarHidden = true
    }
    
    override func viewWillDisappear(_ animated: Bool) {
        super.viewWillDisappear(animated)
        self.navigationController?.isNavigationBarHidden = false
    }
    
    //processing double tap here
    @IBAction func handleStartDoubleTapped(_ sender: UITapGestureRecognizer) {
        // only do this if we were stopped
        if sender.numberOfTapsRequired == 1 {
            //call the appropriate function based on current state
            if stopwatch.active {
                stop(stopbutton: StartStopButton)
            } else {
                start(startbutton: StartStopButton)
            }
        } else if stopwatch.active{
            restart()
        }
    }
    
    
    func restart() {
        stopwatch.restart()
        timer.invalidate()
        self.LapTimeLabel.text = "0:00:00.0"
        self.TotalLapTimeLabel.text = "0:00:00.0"
        self.lapNumberLabel.text = "0"
        self.StartStopButton.setTitle("START", for: .normal)
        self.StartStopButton.setTitleColor(.green, for: .normal)
        self.LapTrackerButton.backgroundColor = .white
        self.LapTrackerButton.setTitle("Lapster", for: .normal)
    }
    
    @IBAction func LapTrackerButtonPressed(_ sender: UIButton) {
        if stopwatch.active {
            stopwatch.nextLap()
        } else {
            performSegue(withIdentifier: "goToTableView", sender: self)
        }
    }
    
    func start(startbutton: UIButton) {
        // set stopwatch state to active
        stopwatch.active = true
        //start the stopwatch if its our first lap
        if stopwatch.getLapCount() == 0{
            stopwatch.nextLap()
        }
        
        // Change Lap Tracker logo to next lap button
        LapTrackerButton.setTitle("Laps++", for: .normal)
        
        //Change our UI to a stop button
        startbutton.setTitle("STOP", for: .normal)
        startbutton.setTitleColor(.red, for: .normal)
        
        // Make the new lap button stand out by applying a bg color
        LapTrackerButton.backgroundColor = UIColor.yellow
        
        // Setup a timer which keeps our stopwatch object updated
        timer = Timer.scheduledTimer(withTimeInterval: 0.1, repeats: true, block: {_ in
            let currentLapIndex = self.stopwatch.getLapCount() - 1
            // keep the stopwatch time updated with the timer
            self.stopwatch.incrementLapTimeByDecisecond(lap: currentLapIndex)
            // Set the lap time label to the current lap time
            self.LapTimeLabel.text = self.stopwatch.getFormattedTimeForLap(lap: currentLapIndex)
            // Set the total time label to the total time
            self.TotalLapTimeLabel.text = self.stopwatch.getFormattedTotalTime()
            // Set our lap number to the lap we're on
            self.lapNumberLabel.text = String(currentLapIndex + 1)
        })
    }
    
    func stop(stopbutton: UIButton) {
        //set stopwatch state to inactive
        stopwatch.active = false
        // stop the timer
        timer.invalidate()
        // Change text of stop button back to start button
        stopbutton.setTitle("START", for: UIControl.State.normal)
        stopbutton.setTitleColor(UIColor.green, for: UIControl.State.normal)
        // Change new lap button back to our logo
        LapTrackerButton.setTitle("Lapster", for: .normal)
        // Remove background color of logo
        LapTrackerButton.backgroundColor = UIColor.white
    }
    
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        let laptimes = segue.destination as! LapsTableViewController
        laptimes.stopwatch = self.stopwatch
    }
}

