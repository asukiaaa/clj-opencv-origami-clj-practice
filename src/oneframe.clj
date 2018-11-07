(ns oneframe
  (:require
    [opencv4.core :refer :all]
    [opencv4.video :as v]))

(defn -main[ & args]
    (let [capture (v/new-videocapture) device 0 buffer (new-mat)]
        (doto capture
         (.open device)
         (.read buffer)
         (.release))
    (prn :camera-image-size (cols buffer) (rows buffer))
    (imwrite buffer "oneshot.png")))