(ns oneframe
  (:require
   [opencv4.core :as origami]
   [opencv4.video :as v]))

(defn -main [& args]
  (let [capture (v/new-videocapture) device 0 buffer (origami/new-mat)]
    (doto capture
      (.open device)
      (.read buffer)
      (.release))
    (prn :camera-image-size (origami/cols buffer) (origami/rows buffer))
    (origami/imwrite buffer "oneframe.png")))
