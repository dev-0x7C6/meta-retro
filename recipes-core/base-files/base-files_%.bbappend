PR = "r100"

# Retroarch checking for /mnt and /media directories as candidates
# since mountpoint is in /var/run/media
# we don't need to have those in file manager list

dirs755:remove = "/mnt"
dirs755:remove = "/media"