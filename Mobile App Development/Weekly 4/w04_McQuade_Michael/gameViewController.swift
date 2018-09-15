//
//  gameViewController.swift
//  w04_McQuade_Michael
//
//  Created by Michael McQuade on 9/14/18.
//  Copyright © 2018 Michael McQuade. All rights reserved.
//

import UIKit

class gameViewController: UIViewController {
    
    //Setup some variables we will need to track score, a countdown timer, our current gesture,
    //and time left in round
    var countdownTimer:Timer!
    var timeLeft:Int = 30
    var Score:Int = 0
    var currentGesture:Int = 0
    
    //Get our outlets to objects in the view controller
    @IBOutlet var scoreLabel: UILabel!
    @IBOutlet var timerLabel: UILabel!
    @IBOutlet var gestureImage: UIImageView!
    @IBOutlet var instructionLabel: UILabel!
    //Create an array of all of our images we will use for gestures
    var GestureImages: [UIImage] = [#imageLiteral(resourceName: "TapButton"),#imageLiteral(resourceName: "PinchButton"),#imageLiteral(resourceName: "SwipeLeft"),#imageLiteral(resourceName: "SwipeRight")]
    var GestureNames: [String] = ["Tap","Pinch","Left","Right"]
    
    override func viewDidLoad() {
        super.viewDidLoad()
        //Start our timer at the number above (the number in the view is just a placeholder)
        timerLabel.text = String(self.timeLeft)
        //Start our coundtdown
        startTimer()
        //Pick our first image
        pickGesture()
    }
    
    @IBAction func handleTap(_ sender: UITapGestureRecognizer) {
        if GestureNames[currentGesture] == "Tap" {
            addPoint()
            pickGesture()
        }
    }
    
    @IBAction func handlePinch(_ sender: UIPinchGestureRecognizer) {
        if GestureNames[currentGesture] == "Pinch" {
            addPoint()
            pickGesture()
        }
    }
    @IBAction func handleSwipe(_ sender: UISwipeGestureRecognizer) {
        switch sender.direction {
        case UISwipeGestureRecognizer.Direction.right:
            if GestureNames[currentGesture] == "Right" {
                addPoint()
                pickGesture()
            }
        case UISwipeGestureRecognizer.Direction.left:
            if GestureNames[currentGesture] == "Left" {
                addPoint()
                pickGesture()
            }
        default:
            break
        }
    }
    
    func addPoint() {
        self.Score = self.Score + 1
        self.scoreLabel.text = "Score: " + String(self.Score)
    }
    
    func pickGesture() {
        //Randomly picks a gesture image and assigns it to the UIImageView for gestures
        var nextGesture = Int.random(in: 0 ..< 4)
        while nextGesture == self.currentGesture{
            nextGesture = Int.random(in: 0 ..< 4)
        }
        self.currentGesture = nextGesture
        self.gestureImage.image = self.GestureImages[self.currentGesture]
        self.instructionLabel.text = self.GestureNames[currentGesture] == "Right" || self.GestureNames[currentGesture] == "Left" ? "Swipe " + self.GestureNames[currentGesture] : self.GestureNames[currentGesture]
    }
    
    func startTimer() {
        //The block will be run every time 1 second passes until the timer is invalidated.
        countdownTimer = Timer.scheduledTimer(withTimeInterval: 1, repeats: true, block: { _  in
            //Reduce our timer by 1
            self.timeLeft = self.timeLeft - 1
            //Set timer label on each tick
            self.timerLabel.text = String(self.timeLeft)
            //If we're out of time we should get rid of the timer and segue to game over screen
            if self.timeLeft <= 0 {
                self.countdownTimer.invalidate()
                //do game over stuff here
                self.performSegue(withIdentifier: "segueToGameOver", sender: self)
            }
            
        })
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        let destination: gameOverViewController = segue.destination as! gameOverViewController
        destination.finalScore = self.Score
        //self.dismiss(animated: false, completion: nil)
    }
    
    @IBAction func handleGoBack(_ sender: UIButton) {
        //TODO: handle resetting the game to initial score/state here
        
        //dismiss the current view controller, bringing us back to main screen
        dismiss(animated: false, completion: nil )
    }
    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */

}
