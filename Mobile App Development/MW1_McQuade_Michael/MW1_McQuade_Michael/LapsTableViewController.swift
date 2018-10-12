//
//  LapsTableViewController.swift
//  MW1_McQuade_Michael
//
//  Created by Michael E McQuade on 9/29/18.
//  Copyright © 2018 giraffesyo.io. All rights reserved.
//

import UIKit

class LapsTableViewController: UITableViewController {
    
    var stopwatch: Stopwatch = Stopwatch()
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(animated)
        // Change navigation controller to non-optional
        if let navcontroller = self.navigationController {
            // get height/width of navigation controller
            let height = navcontroller.toolbar.frame.height
            let width = navcontroller.toolbar.frame.width
            //create label with the height/width same as nav controller
            let averageLabel = UILabel(frame: CGRect(x: 0, y: 0, width: width, height: height))
            // Set label text to the average time
            averageLabel.text = "Average: \(stopwatch.getFormattedAverageTime())"
            // Center text
            averageLabel.textAlignment = NSTextAlignment.center
            // Create bar button item with the label
            let toolbarLabel = UIBarButtonItem(customView: averageLabel)
            // add this label to the toolbar
            self.toolbarItems = [toolbarLabel]
        }
    }
    override func viewDidLoad() {
        super.viewDidLoad()
    }
    
    // MARK: - Table view data source
    // One section
    override func numberOfSections(in tableView: UITableView) -> Int {
        return 1
    }
    
    // Number of rows is equal to the number of laps
    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return stopwatch.getLapCount()
    }
    
    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        // get next cell
        let cell = tableView.dequeueReusableCell(withIdentifier: "lap time cell", for: indexPath)
        
        // Configure the cell...
        // Cell label is equal to the formatted time for the lap
        cell.textLabel?.text = "Lap \(indexPath[1]+1): \(stopwatch.getFormattedTimeForLap(lap: indexPath[1]))"
        return cell
    }
    
    
    /*
     // Override to support conditional editing of the table view.
     override func tableView(_ tableView: UITableView, canEditRowAt indexPath: IndexPath) -> Bool {
     // Return false if you do not want the specified item to be editable.
     return true
     }
     */
    
    /*
     // Override to support editing the table view.
     override func tableView(_ tableView: UITableView, commit editingStyle: UITableViewCellEditingStyle, forRowAt indexPath: IndexPath) {
     if editingStyle == .delete {
     // Delete the row from the data source
     tableView.deleteRows(at: [indexPath], with: .fade)
     } else if editingStyle == .insert {
     // Create a new instance of the appropriate class, insert it into the array, and add a new row to the table view
     }
     }
     */
    
    /*
     // Override to support rearranging the table view.
     override func tableView(_ tableView: UITableView, moveRowAt fromIndexPath: IndexPath, to: IndexPath) {
     
     }
     */
    
    /*
     // Override to support conditional rearranging of the table view.
     override func tableView(_ tableView: UITableView, canMoveRowAt indexPath: IndexPath) -> Bool {
     // Return false if you do not want the item to be re-orderable.
     return true
     }
     */
    
    /*
     // MARK: - Navigation
     
     // In a storyboard-based application, you will often want to do a little preparation before navigation
     override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
     // Get the new view controller using segue.destination.
     // Pass the selected object to the new view controller.
     }
     */
    
}
